const express = require('express');
const fs = require('fs');
const path = require('path');

const app = express();
const PORT = 3000;

// Base folder for all code
const basePath = __dirname;

// Serve static files from public/
app.use(express.static('public'));

// Route: Get list of files for a language
app.get('/api/files', (req, res) => {
  const lang = req.query.lang;
  const folderMap = {
    C: path.join(__dirname, 'C'),
    Java: path.join(__dirname, 'Java'),
    Python: path.join(__dirname, 'Python')
  };

  const folderPath = folderMap[lang];
  if (!folderPath) return res.status(400).json({ error: 'Invalid language' });

  fs.readdir(folderPath, (err, files) => {
    if (err) return res.status(500).json({ error: 'Unable to read folder' });

    const filtered = files.filter(f =>
      (lang === 'C' && f.endsWith('.c')) ||
      (lang === 'Java' && f.endsWith('.java')) ||
      (lang === 'Python' && f.endsWith('.py'))
    );

    const withTimestamps = filtered.map(file => {
      const stats = fs.statSync(path.join(folderPath, file));
      return { name: file, modified: stats.mtime };
    });

    res.json(withTimestamps);
  });
});


// Route: Get code content of a selected file
app.get('/api/code', (req, res) => {
  const { file, lang } = req.query;
  if (!file || !lang) return res.status(400).send('Missing file or language');

  const folderPath = path.join(basePath, lang);
  const filePath = path.join(folderPath, file);

  if (!fs.existsSync(filePath)) return res.status(400).send('Invalid file path');

  fs.readFile(filePath, 'utf-8', (err, code) => {
    if (err) return res.status(500).send('Error reading file');
    res.send(code);
  });
});

// Start server
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
