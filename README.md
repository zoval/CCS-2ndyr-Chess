# CCS-2ndyr-Chess

A JavaFX chess game for the CCS 2nd-year BSCS/BSIT team. This repository currently
contains the application foundation; chess rules, AI, and online play will be added
incrementally.

## Prerequisites

- JDK 17 or newer
- Apache Maven 3.9 or newer

JavaFX is supplied through Maven, so no separate JavaFX SDK installation is required.

## Build, run, and test

```text
mvn clean test
mvn javafx:run
```

The first command compiles the application and runs the unit tests. The second starts
the minimal JavaFX shell.

## Project layout

- `com.ccs.chess.model` - board, piece, and game-state domain objects
- `com.ccs.chess.game` - turn/game orchestration
- `com.ccs.chess.ui` - JavaFX views and application entry point
- `com.ccs.chess.ai` - computer-player contracts and implementations
- `com.ccs.chess.networking` - transport and online-play integration
- `com.ccs.chess.backend` - sessions, persistence, and service boundaries
- `src/main/resources/assets` - images, stylesheets, and other runtime assets
- `src/test/java` - unit and model tests

## Team ownership boundaries

Keep domain rules independent of JavaFX, networking, and persistence. The model/game
team owns state transitions and legal-move behavior; the UI team owns presentation and
input mapping; the AI team consumes game-state interfaces without changing UI code; the
networking/backend team owns transport, sessions, and persistence. Coordinate shared
interfaces before changing them and keep adapters at package boundaries.

## Branch and PR workflow

Create a focused branch from `main` (for example, `feature/board-model`), make small
commits, and open a pull request back to `main`. Pull requests should include tests for
behavior changes, pass `mvn clean test`, and have at least one teammate review. Avoid
mixing rule changes, UI changes, and infrastructure changes in one PR unless they are
required for the same feature.
