@Library('jenkinslibrary') _
pipeline{
    agent any

    environment{
        buildnumber = "${env.BUILD_NUMBER}"
        id= "sonar" 
    }

    parameters{

        string(name: 'branch', description: "choose the branch", defaultValue: 'main')
    }

    stages{

        stage("Git Checkout"){
            steps{
                
                script{     
                    gitCheckout(
                        branch: "${params.branch}",
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
                    staticCodeAnalysis(id)
                }
            }
        }

        stage("Quality Gate Check : Sonar"){
            steps{
                
                script{    
                    qualityCheck(id)
                }
            }
        }

        stage("Maven Build : Maven"){
            steps{
                
                script{     
                    mavenBuild()
                }
            }
        }

        stage("Docker Build : Docker"){
            steps{
                
                script{     
                    dockerBuild(buildnumber)
                }
            }
        }

        stage("Docker Tag : Docker"){
            steps{
                
                script{     
                    dockerTag(buildnumber)
                }
            }
        }

        stage("Docker push : Docker"){

            steps{
                withDockerRegistry(credentialsId: 'gcr:viu-browser-qa', url: "https://us.gcr.io") {
                    script{     
                     dockerPush(buildnumber)
                    }
    
                }
                
            }
        }
    }
    
}