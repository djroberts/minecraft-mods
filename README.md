# Horse Meat Mod

A Minecraft Forge mod for version 1.21.1 that adds extra meat drops from horses.

## Features

- **50% chance** for 1-3 cooked beef (horse sausage) when killing horses
- **30% chance** for 1-2 cooked porkchop (frikandel) when killing horses

## Installation

1. Download the latest release from the [Releases page](https://github.com/djroberts/minecraft-mods/releases)
2. Place the JAR file in your Minecraft mods folder
3. Launch Minecraft with Forge 1.21.1

## Building

This mod is built automatically via GitHub Actions on Ubuntu, which bypasses the Apple Silicon LWJGL issues.

To build locally (requires fixing LWJGL issues on Apple Silicon):

```bash
# Set up Java 21
export JAVA_HOME=/path/to/java21

# Build the mod
./gradlew build
```

## Requirements

- Minecraft 1.21.1
- Forge 52.1.10
- Java 21

## License

All Rights Reserved
