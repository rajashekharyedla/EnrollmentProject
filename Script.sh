node {
try {
    
    notify('IN_PROGRESS')
   stage('CheckOut') {
     echo 'configure started'
     git 'https://github.com/rajashekharyedla/EnrollmentProject.git'
    echo 'configure done'
  }
 stage('Build') {
        if (isUnix()) {
        echo 'its an unix enviranment'
        sh "${tool 'M3'}/bin/mvn install"
        } else {
        echo 'its an windows environment'
        bat "${tool 'M3'}/bin/mvn  install" 
        }
    } 
    stage('Code Quality') {
		parallel sonar: {
                 if (isUnix()) {
                   echo 'its an unix enviranment'
                    sh "${tool 'M3'}/bin/mvn sonar:sonar -P coverage-per-test"
                 } else {
                     bat 'mvn sonar:sonar -P coverage-per-test'
                 }
	    	},
		    unittestcoverage: {
	        	if (isUnix()) {
                     echo 'its an unix enviranment'
                     sh "${tool 'M3'}/bin/mvn cobertura:cobertura"
                      publishHTML (target: [
              allowMissing: false,
              alwaysLinkToLastBuild: false,
              keepAll: true,
              reportDir: 'target/site/cobertura',
              reportFiles: 'index.html',
              reportName: 'Coverage Report',
              reportTitle: 'Code coverage'
         ])
                } else {
                     echo 'its an windows environment'
                     bat "${tool 'M3'}/bin/mvn cobertura:cobertura" 
                }
                
	    	}
        
    }
	 stage('JUnit tests') {
        if (isUnix()) {
        echo 'its an unix enviranment'
        sh "${tool 'M3'}/bin/mvn test"
        junit '**\\target\\surefire-reports\\*.xml'
        }else {
        echo 'its an windows environment'
        bat "${tool 'M3'}/bin/mvn test"
        junit '**\\target\\surefire-reports\\*.xml'
        }
    } 
    stage('deployment') {
        if (isUnix()) {
            /*sh 'sudo -S true'*/
            sh 'docker-compose build'
            sh 'docker-compose up -d'    
        } else {
            bat 'docker-compose build'
            bat 'docker-compose up -d'           
        }
    }
    notify('SUCCESSFUL')
 } catch (e) {
    notify('FAILED')
    throw e
  }
}
    def notify(String buildStatus) {
    emailext (
      subject: "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
      body: """<p>${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
			   <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>""",
       to : "rajashekhary@wavelabs.in"
    ) 
}
