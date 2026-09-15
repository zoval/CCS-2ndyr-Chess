# Team Build Workflow

This project is a JavaFX chess game. Each team should build inside its assigned package, agree on shared interfaces before changing them, and keep `mvn clean test` passing before merging work into `main`.

## Shared Rules

- Start each feature from an updated `main` branch.
- Keep pull requests small and focused on one feature area.
- Do not commit generated `target/` files.
- Add or update tests for game rules, board state, session logic, and any behavior that can be checked without launching JavaFX.
- Run `mvn clean test` before asking for review.
- If a change touches another team's package, coordinate first and document the contract in code or tests.

## Model Team - Team Sulasok

Package: `src/main/java/com/ccs/chess/model`

Build the chess domain objects. This package should not depend on JavaFX, networking, backend storage, or AI classes.

Responsibilities:

- Represent the board, squares, coordinates, pieces, colors, and move data.
- Track piece placement and game state in plain Java objects.
- Provide safe methods for reading board state without exposing mutable internals.
- Add unit tests in `src/test/java/com/ccs/chess/model`.

First milestones:

- Add `Piece`, `PieceType`, `PieceColor`, `Square`, and `Move` model types.
- Extend `Board` from dimensions only into board state.
- Test valid board setup and invalid coordinates.

## Game Rules Team - Team Rene Baterbonia

Package: `src/main/java/com/ccs/chess/game`

Build the game orchestration layer. This package coordinates turns and rules using the model package.

Responsibilities:

- Initialize a standard chess game.
- Validate legal moves for each piece.
- Enforce turn order, check, checkmate, stalemate, castling, en passant, and promotion.
- Return clear results for attempted moves so the UI, AI, and networking teams can react.
- Keep rule logic independent of JavaFX screens.

First milestones:

- Add a move result type that reports success, illegal move, check, checkmate, or promotion required.
- Implement basic turn switching and piece movement.
- Add tests for pawn, rook, bishop, knight, queen, and king movement.

## UI Team - Team Sulasok

Package: `src/main/java/com/ccs/chess/ui`

Build the JavaFX experience. The UI should display game state and send player actions to the game layer.

Responsibilities:

- Render an 8x8 chessboard with pieces.
- Let players select a piece and choose a destination square.
- Show whose turn it is and display invalid move messages.
- Support game reset and promotion selection.
- Keep UI code out of the model and game rule packages.

First milestones:

- Replace the placeholder label with a board grid.
- Add click handling for selecting and moving pieces.
- Add basic CSS or JavaFX styling for light and dark squares.

## AI Team - Team Michelin Stars

Package: `src/main/java/com/ccs/chess/ai`

Build computer-player behavior behind the `MoveProvider` boundary.

Responsibilities:

- Read game state from `ChessGame` without changing UI code.
- Choose legal moves using the game rules API.
- Start with a simple random legal move provider.
- Later add stronger strategies such as material scoring or minimax.

First milestones:

- Update `MoveProvider` so it returns a selected move instead of directly mutating the game.
- Add a random move provider once legal move generation exists.
- Add tests for move selection when legal moves are available and unavailable.

## Networking Team - Team Michelin Stars

Package: `src/main/java/com/ccs/chess/networking`

Build the online-play transport layer. This package should move game events between players without owning chess rules.

Responsibilities:

- Define connect, disconnect, send move, and receive move operations.
- Serialize and deserialize move data from the model package.
- Report connection state and transport errors.
- Keep networking code independent from JavaFX controls.

First milestones:

- Expand `GameTransport` with methods for sending and receiving moves.
- Add an in-memory or mock transport for testing.
- Document the message format used for moves and session events.

## Backend Team - Team Hambuger

Package: `src/main/java/com/ccs/chess/backend`

Build session and persistence boundaries. This package owns game sessions, saved state, and service-style coordination.

Responsibilities:

- Create and end game sessions.
- Track local player names, game mode, and session status.
- Save and load games if persistence is added.
- Provide APIs that the UI and networking teams can call without knowing storage details.

First milestones:

- Expand `SessionManager` with session creation and ending methods.
- Add a session model with IDs, players, and status.
- Add unit tests for session lifecycle behavior.

## Integration Order

1. Model team creates the core board and move types.
2. Game rules team uses those types to implement legal moves and turn flow.
3. UI team connects board clicks to game actions.
4. AI team consumes legal move generation.
5. Networking team sends model-level move data between players.
6. Backend team tracks sessions and saved game state around the working game.

## Pull Request Checklist

- The change belongs mostly to the assigned package.
- Shared contracts are documented through method names, Javadocs, or tests.
- Unit tests cover new behavior where practical.
- `mvn clean test` passes.
- No generated `target/` files are included.
- At least one teammate reviewed the pull request.
