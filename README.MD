
# DemoDisablerMod

## Overview

DemoDisablerMod is a Minecraft Forge mod designed to disable the limitations imposed by the Minecraft demo mode. Once activated, it allows players to access multiplayer features, chat, and removes all demo restrictions directly from the main menu.

## Requirements

- **Minecraft Forge 1.16.5**: The mod is built and tested solely for this version using its specific mappings. Compatibility with other versions or mappings may be limited and could require modifications.
- **Java 8 or higher**

## Installation

1. Ensure you have Minecraft installed.
2. Install Minecraft Forge for your corresponding Minecraft version if you haven't done so already. Forge installer can be downloaded from [the official Forge website](http://files.minecraftforge.net/).
3. Download the `DemoDisablerMod.jar` file.
4. Place the downloaded `.jar` file into the `mods` folder in your Minecraft directory:
   - **Windows**: `%appdata%\.minecraft\mods`
   - **Mac/Linux**: `~/.minecraft/mods`
5. Run Minecraft through the Forge profile.

## Building from Source

To build the mod from the source, follow these steps:

1. Clone the repository to your local machine.
2. Navigate to the cloned directory.
3. Use the following Gradle command to build the project:

   ```bash
   gradle build
   ```

The build output, `jar file`, will be located in the `build/libs` folder.

## Usage

Once installed, the mod automatically integrates with Minecraft. Start your game, and the demo mode restrictions will be disabled when you access the main menu. No additional steps or configurations are required post-installation.

## License

This project is available under the MIT License. See the LICENSE file for more details.