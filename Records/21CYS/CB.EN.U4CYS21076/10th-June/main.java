import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

abstract class FileTransfer {
    private List<FileTransferListener> listeners;

    public FileTransfer() {
        listeners = new ArrayList<>();
    }

    public void addListener(FileTransferListener listener) {
        listeners.add(listener);
    }

    public void removeListener(FileTransferListener listener) {
        listeners.remove(listener);
    }



    public void sendFile(String filename) {
        System.out.println("Sending file: " + filename);
        // Perform necessary operations to send the file to the server
        // For demonstration purposes, let's assume the file transfer is successful
        byte[] fileData = readFromFile(filename);
        saveFile(fileData, filename);
    }

    abstract void saveFile(byte[] fileData, String filename);

    protected void notifyFileSent(String filename) {
        for (FileTransferListener listener : listeners) {
            listener.onFileSent(filename);
        }
    }

    protected void notifyFileSaved(String filename) {
        for (FileTransferListener listener : listeners) {
            listener.onFileSaved(filename);
        }
    }

    private byte[] readFromFile(String filename) {
        try {
            File file = new File(filename);
            byte[] fileData = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(fileData);
            fileInputStream.close();
            return fileData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

interface FileTransferListener {
    void onFileSent(String filename);
    void onFileSaved(String filename);
}

class FileTransferClient extends FileTransfer {
    @Override
    void saveFile(byte[] fileData, String filename) {
        // Client doesn't save files, only sends them
    }
}

class FileTransferServer extends FileTransfer {
    @Override
    void saveFile(byte[] fileData, String filename) {
        System.out.println("Saving file: " + filename);
        // Perform necessary operations to save the file on the server
        // For demonstration purposes, let's assume the file is successfully saved
        writeToFile(fileData, filename);
        notifyFileSaved(filename);
    }

    private void writeToFile(byte[] fileData, String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            fileOutputStream.write(fileData);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void start() {
        try {
            // Start the server by listening for incoming file transfers
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started. Waiting for connections...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection established with " + clientSocket.getInetAddress());

                // Handle the incoming file transfer in a separate thread
                FileTransferHandler handler = new FileTransferHandler(clientSocket);
                Thread thread = new Thread(handler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class FileTransferHandler implements Runnable {
        private Socket clientSocket;

        public FileTransferHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Read the file data from the client
                DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
                String filename = dataInputStream.readUTF();
                int fileSize = dataInputStream.readInt();
                byte[] fileData = new byte[fileSize];
                dataInputStream.readFully(fileData);

                // Save the received file
                saveFile(fileData, filename);

                // Close the socket
                clientSocket.close();
                System.out.println("Connection closed with " + clientSocket.getInetAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        FileTransferClient client = new FileTransferClient();
        FileTransferServer server = new FileTransferServer();

        // Add listeners to client and server
        client.addListener(new FileTransferListener() {
            @Override
            public void onFileSent(String filename) {
                System.out.println("Client: File sent - " + filename);
            }

            @Override
            public void onFileSaved(String filename) {
                // Not applicable for the client
            }
        });

        server.addListener(new FileTransferListener() {
            @Override
            public void onFileSent(String filename) {
                // Not applicable for the server
            }

            @Override
            public void onFileSaved(String filename) {
                System.out.println("Server: File saved - " + filename);
            }
        });

        // Send file from client to server
        client.sendFile("~/Code/Java/FileTransfer/out/production/File Transfer/example.txt");

        // Start the server
        server.start();
    }
}

