## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Server Documentation

The provided code represents a simple server-side implementation of a messenger application using Java Socket programming and Swing GUI components. The server application allows communication with a client over a network connection.

### Overview

The `Server` class extends the `JFrame` class to create a graphical user interface for the server-side application. It establishes a connection with a client, reads incoming messages, and allows the server to send messages to the client.

### Class Members

- `ServerSocket server`: A `ServerSocket` object that listens for incoming connections on a specified port.
- `Socket socket`: A `Socket` object representing the established connection with the client.
- `BufferedReader br`: A `BufferedReader` object to read data from the client.
- `PrintWriter out`: A `PrintWriter` object to send data to the client.
- `JLabel heading`: A label component displaying the title "SERVER AREA".
- `JTextArea messageArea`: A text area component to display received and sent messages.
- `JTextField messageInput`: A text field component for the user to input messages.
- `Font font`: A font object defining the font style for the GUI components.

### Constructor

The constructor `Server()` is responsible for setting up the server-side application. It performs the following steps:

1. Initializes the `ServerSocket` on port 7777 and waits for a client connection.
2. Establishes a connection with the client using `server.accept()`.
3. Creates instances of `BufferedReader` and `PrintWriter` to handle input and output streams.
4. Invokes the `createGUI()` method to create the graphical user interface.
5. Registers event listeners using `handleEvents()` to handle user input.
6. Starts a separate thread to continuously read messages from the client using `startReading()`.

### GUI Creation

The `createGUI()` method sets up the graphical user interface for the server application. It performs the following tasks:

1. Sets the title, size, location, and close operation for the JFrame.
2. Sets the visibility of the JFrame to true.
3. Configures the font style for the GUI components.
4. Creates a heading label with the text "SERVER AREA" and sets its position and alignment.
5. Creates a text area for displaying messages and sets it to non-editable.
6. Creates a text field for user input.
7. Sets the layout of the frame to BorderLayout.
8. Adds the components to the frame.

### Event Handling

The `handleEvents()` method registers a key listener for the `messageInput` text field. It listens for key events and handles the release of the Enter key (key code 10) as follows:

1. Retrieves the content of the `messageInput` text field.
2. Appends the server's message to the `messageArea` text area.
3. Sends the content to the client using the `PrintWriter`.
4. Clears the `messageInput` text field and requests focus for it again.

### Message Reading

The `startReading()` method creates a separate thread to continuously read messages from the client. It performs the following tasks:

1. Sets up a `Runnable` that defines the reading task.
2. Enters a loop to read messages until the connection is closed.
3. Checks if the received message is "exit" to terminate the chat and display a termination message.
4. Appends the received message to the `messageArea` text area.
5. Handles exceptions that occur when the connection is closed.

### Main Method

The `main()` method serves as the entry point for the server application. It prints a message to the console and creates an instance of the `Server` class to start the server-side functionality.

## Client Documentation

The provided code represents a simple client-side implementation of a messenger application using Java Socket programming and Swing GUI components. The client application allows communication with a server over a network connection.

### Overview

The `Client` class extends the `JFrame` class to create a graphical user interface for the client-side application. It establishes a connection with the server, reads incoming messages, and allows the client to send messages to the server.

### Class Members

- `Socket socket`: A `Socket` object representing the connection with the server.
- `BufferedReader br`: A `BufferedReader` object to read data from the server.
- `PrintWriter out`: A `PrintWriter` object to send data to the server.
- `JLabel heading`: A label component displaying the title "CLIENT AREA".
- `JTextArea messageArea`: A text area component to display received and sent messages.
- `JTextField messageInput`: A text field component for the user to input messages.
- `Font font`: A font object defining the font style for the GUI components.

### Constructor

The constructor `Client()` is responsible for setting up the client-side application. It performs the following steps:

1. Attempts to establish a connection with the server by creating a `Socket` object with the server's address (in this case, "localhost") and port number 7777.
2. Creates instances of `BufferedReader` and `PrintWriter` to handle input and output streams with the server.
3. Invokes the `createGUI()` method to create the graphical user interface.
4. Registers event listeners using `handleEvents()` to handle user input.
5. Starts a separate thread to continuously read messages from the server using `startReading()`.

### GUI Creation

The `createGUI()` method sets up the graphical user interface for the client application. It performs the following tasks:

1. Sets the title, size, location, and close operation for the JFrame.
2. Sets the visibility of the JFrame to true.
3. Configures the font style for the GUI components.
4. Creates a heading label with the text "CLIENT AREA" and sets its position and alignment.
5. Creates a text area for displaying messages and sets it to non-editable.
6. Creates a text field for user input.
7. Sets the layout of the frame to BorderLayout.
8. Adds the components to the frame.

### Event Handling

The `handleEvents()` method registers a key listener for the `messageInput` text field. It listens for key events and handles the release of the Enter key (key code 10) as follows:

1. Retrieves the content of the `messageInput` text field.
2. Appends the client's message to the `messageArea` text area.
3. Sends the content to the server using the `PrintWriter`.
4. Clears the `messageInput` text field and requests focus for it again.

### Message Reading

The `startReading()` method creates a separate thread to continuously read messages from the server. It performs the following tasks:

1. Sets up a `Runnable` that defines the reading task.
2. Enters a loop to read messages until the connection is closed.
3. Checks if the received message is "exit" to terminate the chat and display a termination message.
4. Appends the received message to the `messageArea` text area.
5. Handles exceptions that occur when the connection is closed.

### Main Method

The `main()` method serves as the entry point for the client application. It prints a message to the console and creates an instance of the `Client` class to start the client-side functionality.
