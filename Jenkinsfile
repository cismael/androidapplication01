// Jenkinsfile (Declarative Pipeline)
pipeline {
	agent any

	stages {
		stage('Clean'){
			steps{
				echo  '>>>>>>>>>> Jenkins Build Started'
				echo 'Cleaning..'
				script {
				    gradle clean
// 					if(isUnix()){
// 					    sh 'gradlew clean'
// 					} else {
// 						bat 'gradlew.bat clean'
// 					}
				}
			}
		}
		stage('Checkout'){
			steps {
				echo 'Checkout..'
				checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '35b526e5-7e1e-4fe2-afb4-fde2a7b1b743', url: 'https://github.com/cismael/androidapplication01.git']]])
			}
		}
		stage('Build') {
			steps {
				echo 'Building..'
				script {
				    gradle build --info --warning-mode all --stacktrace
// 					if(isUnix()){
// 					    echo 'UNIX--------------------------------'
// 					    sh 'gradlew build --info --warning-mode all --stacktrace'
// 					} else {
// 						echo 'WINDOWS---------------------------'
// 						bat 'gradlew.bat build --info --warning-mode all --stacktrace'
// 					}
				}
			}
		}
        /*
        stage ("SonarQube Analysis") {
            steps {
                script {
                    // def SonarScannerHome = tool 'SonarQubeScanner';
                    // bat "${SonarScannerHome}/bin/sonar-scanner"
                    // './gradlew --info sonarqube'

                    withSonarQubeEnv('SonarQubeServer') {
                        buildInfo.env.capture = false // verzamel hier niet de build info
                        gradle.deployer.deployArtifacts = false // artifacts moeten niet gedeployed worden
                        gradle.run(
                                rootDir: '',
                                buildFile: 'build.gradle',
                                tasks: 'sonarqube',
                                buildInfo: buildInfo,
                                switches: params.release ? '-Prelease' : '')
                    }
                }
            }
        }
        */
		stage('Test') {
			steps {
				echo 'Testing..'
				script {
				    gradle test
// 					if(isUnix()){
// 					    sh 'gradlew test'
// 					} else {
// 						bat 'gradlew.bat test'
// 					}
				}
			}
		}
		stage('Archivage'){
			steps{
				echo 'Archiving Artefact....'
				archiveArtifacts 'app/build/outputs/apk/**/*.apk'
			}
		}
		stage('Publish JUnit Test Results') {
			steps{
				echo 'Publishing AndroidLint Results....'
				junit '**/build/test-results/**/*.xml'
			}
		}
		stage('Publish AndroidLint Results') {
			steps{
				echo 'Publishing AndroidLint Results....'
				androidLint canComputeNew: false, defaultEncoding: '', healthy: '', pattern: '**/build/reports/lint-results.xml', unHealthy: ''
			}
		}
		stage('Deploy') {
			steps {
				echo 'Deploying....'
			}
		}
	}
}
