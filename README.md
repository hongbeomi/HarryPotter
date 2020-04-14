# <p align="center">Harry Potter</p>

<p align="center">
<img alt="api" src="https://img.shields.io/badge/API-21%2B-green?logo=android"/>
<img alt="build" src="https://img.shields.io/github/workflow/status/hongbeomi/HarryPotter/Android%20CI/master"/>
<img alt="license" src="https://img.shields.io/github/license/hongbeomi/FindTaek?color=blue&logo=apache"/>
</p>

<p align="center">Harry Potter Application is sample based on MVVM architecture.</br>
Fetch data from the network via repository pattern.</p>

![logo](https://github.com/hongbeomi/HarryPotter/blob/master/preview/logo.png)

<br>

## Download

Go to ths [releases](https://github.com/hongbeomi/HarryPotter/releases/tag/v1.0.0) to download the APK

<img src="https://github.com/hongbeomi/HarryPotter/blob/master/preview/demo.gif" align="right" width="20%"></img>

<br>

## Stack & Libraries

- Minimum SDK level 21
- [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- JetPack
  - LiveData -Build data objects that notify views when the underlying database changes.
  - Lifecycle - Create a UI that automatically responds to lifecycle events.
  - ViewModel - UI related data holder, Easily schedule asynchronous tasks for optimal execution.
- [Koin](https://github.com/InsertKoinIO/koin) - dependency injection.
- [Retrofit2](https://github.com/square/retrofit) - REST APIs.
- [OkHttp3](https://github.com/square/okhttp) - implementing interceptor, logging web server.
- [Glide](https://github.com/bumptech/glide) - loading images.
- [DiscreteScrollView](https://github.com/yarolegovich/DiscreteScrollView) - scrollable list of items.
- [Lottie](https://github.com/airbnb/lottie-android) - implementing animations
- [Material-Dioalog](https://github.com/afollestad/material-dialogs) - material dialog.

<br>

## Architecture

Harry Potter does not use a Local database.

![architecture](https://github.com/hongbeomi/HarryPotter/blob/master/preview/mvvm.png)

<br>

## 🌟 Find this project useful?

Support it by joining [stargazers](https://github.com/hongbeomi/HarryPotter/stargazers) for this repository

<br>

## 📝 License

```
Copyright 2020 Hongbeom Ahn

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
```