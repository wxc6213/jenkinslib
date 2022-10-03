#!groovy
@Library('jenkinslib')_
def tools = new org.devops.tools()

pipeline {
    agent any
    options{
	timestamps()//日志会有时间
	skipDefaultCheckout()//删除隐式checkout scm语句
	disableConcurrentBuilds()//禁止并行
    }
    stages {
        stage('GetCode') {
	        when { environment name: 'username', value: 'wxc' }
            steps{
               timeout(time:5,unit:"MINUTES"){
                   script{
                       println('获取代码')
		               input id: 'Test', message: '是否要继续？', ok: '是，继续吧', parameters: [choice(choices: ['a', 'b'], name: 'test1')], submitter: 'wxc,admin'
                   }
               }
           }
        }
        stage('01'){
    		failFast true
    		parallel{
    			//构建
    			stage('Build') {
    			   steps{
    			       timeout(time:20,unit:"MINUTES"){
    				   script{
    				       println('应用打包 ')
    				     }
    			       }
    			   }
    			}
    			//代码扫描
    			stage('CodeScan') {
    			   steps{
    			       timeout(time:30,unit:"MINUTES"){
    				   script{
    				       println('代码扫描 ')
    				       tools.PrintMes("this is my lib!")
    				    }
    			       }
    			   }
    			}
    		
    		}
	    }
       
    }
    post{
	    always{
    	   script{
    		println("always")
    	   }	
	}
	    success{
    	   script{
    		currentBuild.description = "\n 构建成功"
    	   }
	}
    	failure{
    	   script{
    		currentBuild.description = "\n 构建失败"
    	   }
    	}
    	aborted{
    	   script{
    		currentBuild.description = "\n 构建取消"
    	   }
    	}
    }
}
