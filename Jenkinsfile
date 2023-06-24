@Library('jenkinslibrary') _
pipeline{
    agent any

    stages{

        stage("Git Checkout"){
            steps{
                
                script{     
                    gitCheckout(
                        branch: "main",
                        url: "https://github.com/jithujijo/ci-cd-automation.git"
                    )
                }
            }
        }
        stage("Unit Test : Maven"){
            steps{
                
                script{     
                    mavenTest()
                }
            }
        }
        stage("Maven Integration Test : Maven"){
            steps{
                
                script{     
                    mavenIntegrationTest()
                }
            }
        }

        stage("Static Code Analysis : Sonar"){
            steps{
                
                script{
                    def id= 'sonar'     
                    staticCodeAnalysis(id)
                }
            }
        }

        stage("Quality Gate Check : Sonar"){
            steps{
                
                script{
                    def id= 'sonar'     
                    qualityCheck(id)
                }
            }
        }

        stage("Maven Build : Maven"){
            steps{
                
                script{     
                    mavenBiuld()
                }
            }
        }
    }
    
}