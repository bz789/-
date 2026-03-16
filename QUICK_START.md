# 道痕日记 - 快速开始指南

## 方法1：使用GitHub Actions自动构建（无需安装Android Studio）

### 步骤1：创建GitHub仓库
1. 访问 https://github.com/new
2. 创建一个新的公开仓库，命名为 "daojiary" 或 "道痕日记"
3. **不要**勾选 "Initialize this repository with a README"
4. 点击 "Create repository"

### 步骤2：上传项目代码

**使用Git命令行（推荐）：**
```bash
cd c:/Users/bz/WorkBuddy/20260316213144
git init
git add .
git commit -m "Initial commit: 道痕日记应用"
git branch -M main
git remote add origin https://github.com/你的用户名/daojiary.git
git push -u origin main
```

**或者使用GitHub Desktop：**
1. 打开GitHub Desktop
2. File → Add Local Repository
3. 选择项目文件夹：`c:/Users/bz/WorkBuddy/20260316213144`
4. Publish repository

### 步骤3：触发自动构建

**方式A：推送代码后自动构建**
- 代码推送到GitHub后会自动触发构建

**方式B：手动触发构建**
1. 访问你的GitHub仓库
2. 点击 "Actions" 标签
3. 选择 "Build APK" workflow
4. 点击 "Run workflow" 按钮
5. 选择 "main" 分支，点击 "Run workflow"

### 步骤4：下载APK
1. 等待构建完成（约3-5分钟）
2. 在Actions页面点击最新的构建任务
3. 滚动到底部的 "Artifacts" 部分
4. 下载 "daojiary-debug" 或 "daojiary-release"
5. 解压下载的zip文件，得到 `.apk` 文件

### 步骤5：安装到手机
1. 将APK文件传输到手机
2. 在手机上打开APK文件
3. 允许安装未知来源的应用
4. 完成安装

---

## 方法2：使用Android Studio构建

### 前置准备
1. 下载Android Studio：https://developer.android.com/studio
2. 安装并启动Android Studio
3. 等待初次配置完成（下载SDK等）

### 构建步骤
1. **打开项目**
   - 选择 "Open an Existing Project"
   - 导航到：`c:/Users/bz/WorkBuddy/20260316213144`
   - 等待Gradle同步（首次需要5-10分钟）

2. **构建APK**
   - 菜单栏：Build → Build Bundle(s) / APK(s) → Build APK(s)
   - 等待构建完成（2-3分钟）
   - 点击通知中的 "locate" 查看APK位置
   - APK位于：`app/build/outputs/apk/debug/app-debug.apk`

3. **安装到手机**
   - 连接手机到电脑（开启USB调试）
   - 在Android Studio中点击 "Run" 按钮
   - 或使用命令：`adb install app-debug.apk`

---

## 方法3：使用命令行（需要Android SDK）

如果您已安装Android SDK但不想用Android Studio：

```bash
cd c:/Users/bz/WorkBuddy/20260316213144

# Windows
gradlew.bat assembleDebug

# Linux/Mac
./gradlew assembleDebug

# APK位置：app/build/outputs/apk/debug/app-debug.apk
```

---

## 常见问题

### Q1: 构建失败怎么办？
A: 查看GitHub Actions的构建日志，通常是因为：
- SDK版本问题
- 依赖下载失败
- 代码错误

### Q2: APK无法安装？
A: 确保手机允许安装未知来源的应用：
- 设置 → 安全 → 允许安装未知应用

### Q3: 应用闪退？
A: 这可能是debug版的问题，请使用release版本

### Q4: 没有GitHub账号？
A: 需要先注册GitHub账号（免费）：https://github.com/signup

---

## 推荐方案

**如果您没有Android Studio**：使用方法1（GitHub Actions）
- 最简单，无需下载大文件
- 自动化构建，可靠稳定
- 可以分享给他人

**如果您需要修改代码**：使用方法2（Android Studio）
- 可以实时预览效果
- 方便调试和修改
- 适合开发者

---

## 获取帮助

如果遇到问题，请检查：
1. GitHub Actions的构建日志
2. README.md中的详细说明
3. PROJECT_OVERVIEW.md中的架构文档

**祝您使用愉快！**
