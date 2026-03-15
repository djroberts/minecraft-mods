# Horse Meat Mod

A Minecraft Forge mod for version 1.21.1 that adds horse meat items and cooking mechanics.

## Features

- **Raw Horse Meat** - Dropped from horses when killed
- **Horse Steak** - Cooked from raw horse meat using furnace or campfire (sneak + right-click)
- **Frikandel** - Cooked from raw horse meat using smoker (sneak + right-click)
- **Custom Cooking System** - Sneak + right-click on cooking blocks with raw horse meat:
  - Furnace/Campfire → Horse Steak
  - Smoker → Frikandel
- **Food & Drink Category** - All items appear in the standard Food & Drink creative tab

## Items

| Item | Food Value | Saturation | How to Obtain |
|------|------------|------------|---------------|
| Raw Horse Meat | 3 | 0.3 | Dropped from horses |
| Horse Steak | 8 | 0.8 | Cook raw horse meat in furnace/campfire |
| Frikandel | 6 | 0.6 | Cook raw horse meat in smoker |

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
