# Alco Calendar Application

A user-friendly application designed to help users manage their alcohol consumption by tracking intakes and associated media for each session.

## Features

- **Calendar Screen**:
    - Displays a calendar of alcohol intakes.
    - Switches between two modes: year view and month view.

- **Session Manage Screen**:
    - Displays detailed alcohol session information: date, intakes, media, etc.
    - Allows users to add, update, and delete intake information.
    - Enables users to upload media associated with a particular session (e.g., photos, notes).
    - Provides an option to add personal notes about the session.
    - Utilizes animations for smooth transitions between elements.

- **Architecture**:
    - Follows the MVVM architectural pattern.
    - Utilizes Android Clean Architecture layers.

- **Architecture**:
    - Follows the MVVM architectural pattern for better separation of concerns.
    - Utilizes Android Clean Architecture layers to enhance maintainability and testability.

## Libraries Used
- **Room:** For sessions data storage.
- **Dagger Hilt:** For dependency injection.
- **Jetpack Compose:** For UI implementation.
- **Coil:** For images display.
