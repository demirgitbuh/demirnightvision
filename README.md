# Demir's Night Vision Mod

A simple Minecraft Fabric mod that adds a toggleable Night Vision effect.
Extract the build-gradle-src.zip file to access the Build, Gradle, and src directories.
## Features

- 🌙 **Toggle Night Vision** with the **N** key
- ⚙️ **Configurable keybind** in Options > Controls > Key Binds
- 💬 **On-screen notifications** when toggling
- 🎮 **Client-side only** - no server required

## Requirements

- Minecraft 1.21.1
- Fabric Loader 0.16.9+
- Fabric API

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/installer/) for Minecraft 1.21.1
2. Download [Fabric API](https://modrinth.com/mod/fabric-api) and place it in your `mods` folder
3. Download the mod JAR file and place it in your `mods` folder
4. Launch Minecraft with the Fabric profile

## Usage

1. Enter a world
2. Press **N** to enable Night Vision (you'll see "Night Vision: ON" in green)
3. Press **N** again to disable (you'll see "Night Vision: OFF" in red)

### Changing the Keybind

1. Go to **Options** > **Controls** > **Key Binds**
2. Find **"Demir's Night Vision"** category
3. Click on **"Toggle Night Vision"**
4. Press your desired key

## Building from Source

```bash
# Clone the repository
git clone hhttps://github.com/demirgitbuh/demirnightvision.git
cd nightvisiondemir

# Build the mod
./gradlew build

# Find the JAR in build/libs/
```

## License

MIT License - feel free to use and modify!
