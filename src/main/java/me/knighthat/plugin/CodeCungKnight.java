/*
Copyright 2022 KnightHat

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package me.knighthat.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class CodeCungKnight extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("menu").setExecutor(new MenuCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
