
## Prerequisites

Make sure you have the following installed:
- Git
- Maven

## Running the Project in Gitpod

Gitpod is a cloud-based development environment that lets you start coding instantly. Follow the steps below to set up and run your TestNG tests in Gitpod:

1. **Open the repository in Gitpod:**
   Click the button below to open the repository in Gitpod:
   [![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/your-repository)

2. **Set up the Environment:**
   Gitpod will automatically set up the development environment using the configurations defined in `.gitpod.yml` and `.gitpod.Dockerfile`.

3. **Run the Tests:**
   After the environment is set up, the following Maven commands will be executed automatically:
   ```sh
   ./mvnw clean install
   ./mvnw test
