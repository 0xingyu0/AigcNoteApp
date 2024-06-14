# AIGC Note App

AIGC Note App 是一个整合生成式 AI 技术的笔记应用程序。项目分为三个主要部分：前端、后端和 AI 服务。

## 项目结构

AigcNoteApp/
├── backend/
│ ├── src/
│ │ ├── main/
│ │ │ ├── java/
│ │ │ │ └── com/
│ │ │ │ └── example/
│ │ │ │ └── aigc_note_app/
│ │ │ │ ├── config/
│ │ │ │ │ ├── JwtAuthenticationFilter.java
│ │ │ │ │ └── SecurityConfig.java
│ │ │ │ ├── controller/
│ │ │ │ │ └── AIController.java
│ │ │ │ ├── model/
│ │ │ │ │ └── User.java
│ │ │ │ ├── repository/
│ │ │ │ │ └── UserRepository.java
│ │ │ │ ├── service/
│ │ │ │ │ ├── JwtUtil.java
│ │ │ │ │ └── AIService.java
│ │ │ │ └── AigcNoteAppApplication.java
│ │ └── resources/
│ │ └── application.properties
│ ├── .gitignore
│ ├── mvnw
│ ├── mvnw.cmd
│ ├── pom.xml
│ └── HELP.md
├── frontend/
│ ├── public/
│ ├── src/
│ │ ├── components/
│ │ ├── pages/
│ │ │ ├── GenerateText.js
│ │ │ ├── Login.js
│ │ │ └── Register.js
│ │ ├── services/
│ │ │ └── api.js
│ │ ├── App.css
│ │ ├── App.js
│ │ ├── index.css
│ │ ├── index.js
│ │ └── setupTests.js
│ ├── .gitignore
│ ├── package.json
│ ├── README.md
│ └── package-lock.json
├── ai-service/
│ ├── app.py
│ ├── requirements.txt
│ └── README.md
└── README.md

markdown
複製程式碼

## 前置条件

- **Java 开发工具包 (JDK)**：版本 17
- **Node.js**：版本 14 或更高
- **PostgreSQL**：数据库配置

## 后端设置

### 1. 进入后端目录
```sh
cd backend
```
### 2. 安装 Maven 依赖并构建项目
```sh
mvn clean install
```
### 3. 运行后端服务器
```sh
mvn spring-boot:run
```
### 4. 后端配置
确保 application.properties 配置正确：
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/aigc_note_app
spring.datasource.username=你的数据库用户名
spring.datasource.password=你的数据库密码
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
# AI 服务 URL
ai.service.url=http://localhost:5000

## 前端设置
### 1. 进入前端目录
```sh
cd frontend
```
### 2. 安装 npm 依赖
```sh
npm install
```
### 3. 运行前端开发服务器
```sh
npm start
```
### 4. 代理配置
确保 package.json 中的 proxy 配置指向后端服务器：
```json
"proxy": "http://localhost:8080"
```
## AI 服务设置
### 1. 进入 AI 服务目录
```sh
cd ai-service
```
### 2. 创建并激活 Python 虚拟环境（可选但推荐）
```sh
python -m venv venv
source venv/bin/activate  # 在 Windows 上: venv\Scripts\activate
```
### 3. 安装 Python 依赖
```sh
pip install -r requirements.txt
```
### 4. 运行 AI 服务
```sh
python app.py
```
## 测试整合
一旦所有服务运行：

前端：在浏览器中打开 http://localhost:3000。
后端：应在 http://localhost:8080/api 上可访问。
AI 服务：应在 http://localhost:5000 上运行。
##　贡献
欢迎 fork 代码仓库并提交 pull request。如有重大更改，请先开一个 issue 讨论你想做的更改。

##　许可证
此项目根据 MIT 许可证授权。

这个 README.md 文件应为项目结构、设置说明以及如何运行各个组件提供一个清晰的概述。确保用你的实际 PostgreSQL 凭据替换 你的数据库用户名 和 你的数据库密码。