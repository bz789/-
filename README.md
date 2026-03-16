# 道痕日记 (Daojiary)

一款基于"道痕"自我反思模板的日记应用，采用Notion风格的暗色设计。

## 功能特点

- ✨ **道痕模板**：基于深度反思的日记模板，帮助用户进行自我觉察
- 🌙 **暗色主题**：Notion风格的优雅暗色设计
- 💾 **本地存储**：使用SQLite数据库，数据安全存储在本地
- 📱 **现代UI**：基于Jetpack Compose的Material Design 3界面

## 道痕模板

"道痕"模板包含以下反思问题：

1. 今天最起波澜的一件事是什么
2. 当时我的第一反应是什么
3. 我其实想得到什么
4. 我其实在害怕什么
5. 我给自己找了什么理由
6. 今天捞出来的主石头是什么
7. 如果明天再遇到同样的事，我准备怎么选

## 技术栈

- **语言**: Kotlin
- **UI框架**: Jetpack Compose
- **架构**: MVVM
- **数据库**: Room (SQLite)
- **最低支持**: Android 8.0 (API 26)
- **目标版本**: Android 14 (API 34)

## 构建APK

### 环境要求

- Android Studio Hedgehog (2023.1.1) 或更高版本
- JDK 17
- Android SDK 34

### 构建步骤

1. **克隆或下载项目**

```bash
cd 道痕日记
```

2. **配置local.properties**

确保 `local.properties` 文件中配置了正确的SDK路径：

```properties
sdk.dir=C\:\\Your\\Path\\To\\Android\\Sdk
```

3. **构建Debug APK**

```bash
.\gradlew.bat assembleDebug
```

生成的APK位于：`app/build/outputs/apk/debug/app-debug.apk`

4. **构建Release APK**

```bash
.\gradlew.bat assembleRelease
```

生成的APK位于：`app/build/outputs/apk/release/app-release.apk`

### 使用Android Studio构建

1. 打开Android Studio
2. 选择 "File" -> "Open"
3. 选择项目根目录
4. 等待Gradle同步完成
5. 选择 "Build" -> "Build Bundle(s) / APK(s)" -> "Build APK(s)"
6. 构建完成后，点击通知中的"locate"查看APK位置

## 项目结构

```
app/
├── src/main/java/com/daojiary/app/
│   ├── data/                  # 数据层
│   │   ├── AppDatabase.kt     # Room数据库
│   │   ├── DiaryDao.kt        # 数据访问对象
│   │   ├── DiaryEntry.kt      # 数据实体
│   │   └── DiaryRepository.kt # 数据仓库
│   ├── ui/                    # UI层
│   │   ├── theme/             # 主题
│   │   ├── DiaryListScreen.kt # 日记列表页
│   │   ├── DiaryEditorScreen.kt # 日记编辑页
│   │   └── DiaryViewModel.kt  # ViewModel
│   ├── MainActivity.kt        # 主Activity
│   └── DiaryApplication.kt    # Application类
└── build.gradle.kts          # 应用级构建配置
```

## 使用说明

1. **新建日记**
   - 点击右下角的 `+` 按钮
   - 填写日记标题和道痕模板中的各个问题
   - 点击右上角的 ✓ 保存

2. **查看日记**
   - 在主页点击任意日记卡片
   - 可以编辑或查看内容

3. **删除日记**
   - 在日记卡片上点击删除图标

## 许可证

本项目仅供个人使用和学习。

## 版本信息

- 版本: 1.0
- 构建时间: 2026年3月16日
