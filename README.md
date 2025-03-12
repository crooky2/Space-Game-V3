# Space Game V3

A simple arcade-style space game where you control a spacecraft and shoot incoming asteroids. Navigate through space, avoid collisions, and rack up your high score!

## Background

This project started as a school assignment but has evolved into a personal hobby project. I'm developing it in my free time as a way to improve my Java skills and have fun with game development.

## Getting Started

To run this game locally:

1. Clone this repository
2. Open in VS Code with Java extensions installed
3. Run the main class

## Folder Structure

The workspace is organized as follows:

- `src/`: Source code
  - `core/`: Game logic and mechanics
    - `entities/`: Game objects (Player, Asteroid, Bullet)
    - `managers/`: System managers (EntityManager, CollisionManager, etc.)
    - `specialabilities/`: Special player abilities 
    - `utils/`: Utility classes and constants
  - `graphics/`: Rendering and visual components
    - `ui/`: User interface elements
      - `components/`: Reusable UI components (SlantedButton, GameCanvas)
      - `menus/`: Game menu screens (PauseMenu, DeathScreen, etc.)
- `bin/`: Compiled output files
- `lib/`: External dependencies

The project follows a package structure that separates game logic from rendering concerns.

## Future Development

This is an ongoing project with no defined scope. I'm working on it as inspiration strikes, and will continue to add features as I have time and interest.

Feel free to check back for updates!
