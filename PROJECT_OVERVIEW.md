# 道痕日记 - 项目概览

## 项目简介

**道痕日记**是一款专注于深度自我反思的Android日记应用，采用Notion风格的暗色设计。应用基于"道痕"反思模板，引导用户通过7个深度问题进行自我觉察和成长。

## 核心特性

### 1. 道痕反思模板
- 今天最起波澜的一件事是什么
- 当时我的第一反应是什么
- 我其实想得到什么
- 我其实在害怕什么
- 我给自己找了什么理由
- 今天捞出来的主石头是什么
- 如果明天再遇到同样的事，我准备怎么选

### 2. 设计风格
- **Notion风格暗色主题**
- 深色背景 (#191919)
- 优雅的卡片式布局
- Material Design 3 设计语言
- 流畅的动画效果

### 3. 技术特点
- **本地存储**：使用Room数据库，数据完全在本地
- **现代架构**：MVVM + Clean Architecture
- **响应式UI**：基于Jetpack Compose的声明式UI
- **类型安全**：100% Kotlin开发

## 技术架构

### 架构模式
```
┌─────────────────────────────────────┐
│           UI Layer                   │
│  (Jetpack Compose + ViewModel)      │
├─────────────────────────────────────┤
│         Data Layer                   │
│  (Repository + Room Database)       │
└─────────────────────────────────────┘
```

### 主要组件

#### 数据层 (Data Layer)
- **AppDatabase**: Room数据库配置
- **DiaryDao**: 数据访问接口
- **DiaryEntry**: 日记数据实体
- **DiaryRepository**: 数据仓库层

#### UI层 (UI Layer)
- **MainActivity**: 主Activity和导航
- **DiaryListScreen**: 日记列表页面
- **DiaryEditorScreen**: 日记编辑页面
- **DiaryViewModel**: 视图模型

#### 主题 (Theme)
- **DaojiaryTheme**: 主题配置
- **Typography**: 字体排版
- **ColorScheme**: 暗色配色方案

## 数据模型

### DiaryEntry
```kotlin
data class DiaryEntry(
    val id: Long,              // 主键ID
    val title: String,         // 日记标题
    val event: String,         // 最起波澜的一件事
    val reaction: String,      // 第一反应
    val desired: String,       // 想得到什么
    val fear: String,          // 害怕什么
    val reason: String,       // 找了什么理由
    val mainStone: String,     // 主石头
    val futureChoice: String,  // 未来选择
    val createdAt: Long,       // 创建时间
    val updatedAt: Long        // 更新时间
)
```

## 用户体验流程

### 新建日记
1. 点击右下角 + 按钮
2. 进入日记编辑页面
3. 填写标题和7个反思问题
4. 点击右上角 ✓ 保存

### 查看日记
1. 在主页浏览日记列表
2. 点击日记卡片查看详情
3. 可编辑或删除

### 删除日记
- 在日记卡片上点击删除图标

## 构建和部署

### 开发环境
- **最低Android版本**: API 26 (Android 8.0)
- **目标Android版本**: API 34 (Android 14)
- **JDK版本**: 17
- **Gradle版本**: 8.2
- **Kotlin版本**: 1.9.20

### 构建命令

```bash
# Debug APK
./gradlew assembleDebug

# Release APK
./gradlew assembleRelease
```

### 输出位置
- Debug: `app/build/outputs/apk/debug/app-debug.apk`
- Release: `app/build/outputs/apk/release/app-release.apk`

## 项目结构

```
道痕日记/
├── app/
│   ├── src/main/
│   │   ├── java/com/daojiary/app/
│   │   │   ├── data/              # 数据层
│   │   │   │   ├── AppDatabase.kt
│   │   │   │   ├── DiaryDao.kt
│   │   │   │   ├── DiaryEntry.kt
│   │   │   │   └── DiaryRepository.kt
│   │   │   ├── ui/                # UI层
│   │   │   │   ├── theme/         # 主题
│   │   │   │   │   ├── Theme.kt
│   │   │   │   │   └── Type.kt
│   │   │   │   ├── DiaryListScreen.kt
│   │   │   │   ├── DiaryEditorScreen.kt
│   │   │   │   └── DiaryViewModel.kt
│   │   │   ├── MainActivity.kt
│   │   │   ├── DiaryApplication.kt
│   │   │   └── DiaryViewModelFactory.kt
│   │   ├── res/                  # 资源文件
│   │   │   └── mipmap*/           # 应用图标
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── gradle/
│   └── wrapper/
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── local.properties
├── gradlew
├── gradlew.bat
└── README.md
```

## 未来计划

- [ ] 添加日记搜索功能
- [ ] 支持日记导出为文本
- [ ] 添加数据备份和恢复
- [ ] 支持自定义模板
- [ ] 添加统计和分析功能
- [ ] 支持云同步（可选）

## 版本信息

- **版本号**: 1.0
- **构建日期**: 2026年3月16日
- **包名**: com.daojiary.app
- **应用名称**: 道痕日记

## 许可证

本项目仅供个人学习和使用。

---

**道痕日记 - 记录你的每一次成长**
