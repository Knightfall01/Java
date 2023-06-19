// The program will run successful if you hit refresh before checking
// whether the values are added to the table

package com.amrita.jpl.cys21076.endsem;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    ArrayList<File> getFiles();
    File getFile(String fileName);

}

class FileManagerImpl implements FileManager {
    private final ArrayList<File> files;
    public FileManagerImpl() {
        files = new ArrayList<>();
    }
    @Override
    public void addFile(File file) {
        files.add(file);
    }
    @Override
    public void deleteFile(String fileName) {
        files.removeIf(file -> file.getFileName().equals(fileName));
    }

    @Override
    public ArrayList<File> getFiles() {
        return files;
    }

    @Override
    public File getFile(String fileName) {
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }
}

class FileManagementSystemUI extends JFrame implements ActionListener {
    private JTextField nameTextField, sizeTextField, resolutionTextField, durationTextField;
    private JComboBox<String> typeComboBox;
    private JTable fileTable;
    private DefaultTableModel tableModel;
    private final FileManager fileManager;
    public FileManagementSystemUI() {
        fileManager = new FileManagerImpl();
        initializeUI();
    }
    private void initializeUI() {
        setTitle("com.amrita.jpl.cys21076.endsem.File Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        JLabel nameLabel = new JLabel("com.amrita.jpl.cys21076.endsem.File Name:");
        nameTextField = new JTextField();
        JLabel sizeLabel = new JLabel("com.amrita.jpl.cys21076.endsem.File Size:");
        sizeTextField = new JTextField();
        JLabel typeLabel = new JLabel("com.amrita.jpl.cys21076.endsem.File Type:");
        typeComboBox = new JComboBox<>(new String[]{"com.amrita.jpl.cys21076.endsem.Document", "com.amrita.jpl.cys21076.endsem.Image", "com.amrita.jpl.cys21076.endsem.Video"});
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        inputPanel.add(sizeLabel);
        inputPanel.add(sizeTextField);
        inputPanel.add(typeLabel);
        inputPanel.add(typeComboBox);
        add(inputPanel, BorderLayout.NORTH);
        tableModel = new DefaultTableModel();
        tableModel.addColumn("com.amrita.jpl.cys21076.endsem.File Name");
        tableModel.addColumn("com.amrita.jpl.cys21076.endsem.File Size");
        tableModel.addColumn("Type");
        fileTable = new JTable(tableModel);
        fileTable.getSelectionModel().addListSelectionListener(new FileSelectionListener());
        JScrollPane scrollPane = new JScrollPane(fileTable);
        add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addButton = new JButton("Add com.amrita.jpl.cys21076.endsem.File");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);
        JButton deleteButton = new JButton("Delete com.amrita.jpl.cys21076.endsem.File");
        deleteButton.addActionListener(this);
        buttonPanel.add(deleteButton);
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(this);
        buttonPanel.add(refreshButton);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add com.amrita.jpl.cys21076.endsem.File")) {
            String name = nameTextField.getText();
            String sizeString = sizeTextField.getText();
            String type = (String) typeComboBox.getSelectedItem();
            String resolution = "";
            String duration = "";
            if (type.equals("com.amrita.jpl.cys21076.endsem.Document")) {
                DocumentInputDialog documentInputDialog = new DocumentInputDialog();
                resolution = documentInputDialog.getResolution();
            } else if (type.equals("com.amrita.jpl.cys21076.endsem.Image")) {
                ImageInputDialog imageInputDialog = new ImageInputDialog();
                resolution = imageInputDialog.getResolution();
            } else if (type.equals("com.amrita.jpl.cys21076.endsem.Video")) {
                VideoInputDialog videoInputDialog = new VideoInputDialog();
                duration = videoInputDialog.getDuration();
            }
            if (!name.isEmpty() && !sizeString.isEmpty()) {
                int size = Integer.parseInt(sizeString);
                if (type.equals("com.amrita.jpl.cys21076.endsem.Document")) {
                    Document document = new Document(name, size, resolution);
                    fileManager.addFile(document);
                } else if (type.equals("com.amrita.jpl.cys21076.endsem.Image")) {
                    Image image = new Image(name, size, resolution);
                    fileManager.addFile(image);
                } else if (type.equals("com.amrita.jpl.cys21076.endsem.Video")) {
                    Video video = new Video(name, size, duration);
                    fileManager.addFile(video);
                }
                clearFields();
                displayFiles();
            }
        } else if (e.getActionCommand().equals("Delete com.amrita.jpl.cys21076.endsem.File")) {
            int selectedRow = fileTable.getSelectedRow();
            if (selectedRow != -1) {
                String fileName = (String) tableModel.getValueAt(selectedRow, 0);
                fileManager.deleteFile(fileName);
                displayFiles();
            }
        } else if (e.getActionCommand().equals("Refresh")) {
            displayFiles();
        }
    }
    private void clearFields() {
        nameTextField.setText("");
        sizeTextField.setText("");
        resolutionTextField.setText("");
        durationTextField.setText("");
    }

    private void displayFiles() {
        tableModel.setRowCount(0);
        for (File file : fileManager.getFiles()) {
            if (file instanceof Document) {
                Document document = (Document) file;
                tableModel.addRow(new Object[]{document.getFileName(), document.getFileSize(), "com.amrita.jpl.cys21076.endsem.Document", document.getDocumentType(), "-"});
            } else if (file instanceof Image) {
                Image image = (Image) file;
                tableModel.addRow(new Object[]{image.getFileName(), image.getFileSize(), "com.amrita.jpl.cys21076.endsem.Image", "-", image.getResolution()});
            } else if (file instanceof Video) {
                Video video = (Video) file;
                tableModel.addRow(new Object[]{video.getFileName(), video.getFileSize(), "com.amrita.jpl.cys21076.endsem.Video", "-", video.getDuration()});
            }
        }
    }

    private class FileSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            int selectedRow = fileTable.getSelectedRow();
            if (selectedRow != -1) {
                String fileName = (String) tableModel.getValueAt(selectedRow, 0);
                File file = fileManager.getFile(fileName);
                if (file != null) {
                    nameTextField.setText(file.getFileName());
                    sizeTextField.setText(String.valueOf(file.getFileSize()));
                    if (file instanceof Document) {
                        Document document = (Document) file;
                        typeComboBox.setSelectedItem("com.amrita.jpl.cys21076.endsem.Document");
                        resolutionTextField.setText(document.getDocumentType());
                    } else if (file instanceof Image) {
                        Image image = (Image) file;
                        typeComboBox.setSelectedItem("com.amrita.jpl.cys21076.endsem.Image");
                        resolutionTextField.setText(image.getResolution());
                    } else if (file instanceof Video) {
                        Video video = (Video) file;
                        typeComboBox.setSelectedItem("com.amrita.jpl.cys21076.endsem.Video");
                        durationTextField.setText(video.getDuration());
                    }
                }
            }
        }
    }

    private class DocumentInputDialog {
        private String resolution;
        public DocumentInputDialog() {
            resolution = JOptionPane.showInputDialog(FileManagementSystemUI.this, "Enter the com.amrita.jpl.cys21076.endsem.Document Type:", "com.amrita.jpl.cys21076.endsem.Document Type", JOptionPane.PLAIN_MESSAGE);
        }
        public String getResolution() {
            return resolution;
        }
    }

    private class ImageInputDialog {
        private String resolution;
        public ImageInputDialog() {
            resolution = JOptionPane.showInputDialog(FileManagementSystemUI.this, "Enter the com.amrita.jpl.cys21076.endsem.Image Resolution:", "com.amrita.jpl.cys21076.endsem.Image Resolution", JOptionPane.PLAIN_MESSAGE);
        }
        public String getResolution() {
            return resolution;
        }
    }

    private class VideoInputDialog {
        private String duration;
        public VideoInputDialog() {
            duration = JOptionPane.showInputDialog(FileManagementSystemUI.this, "Enter the com.amrita.jpl.cys21076.endsem.Video Duration:", "com.amrita.jpl.cys21076.endsem.Video Duration", JOptionPane.PLAIN_MESSAGE);
        }
        public String getDuration() {
            return duration;
        }
    }
}

abstract class File implements Serializable {
    private String fileName;
    private int fileSize;
    public File(String fileName, int fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }
    public String getFileName() {
        return fileName;
    }
    public int getFileSize() {
        return fileSize;
    }
}

class Document extends File {
    private String documentType;
    public Document(String fileName, int fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }
    public String getDocumentType() {
        return documentType;
    }
}

class Image extends File {
    private String resolution;
    public Image(String fileName, int fileSize, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }
    public String getResolution() {
        return resolution;
    }
}

class Video extends File {
    private String duration;
    public Video(String fileName, int fileSize, String duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }
    public String getDuration() {
        return duration;
    }
}

public class main {
    public static void main(String[] args) {
        FileManagementSystemUI fileManagementSystemUI = new FileManagementSystemUI();
    }
}
