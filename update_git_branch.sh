#!/bin/bash
echo "Enter the Command to RUN :"
read task
if [ $task == "commit" ]
then
	#Asking for the file name as user input 
	echo "Enter the file name to be Updated :"
	read fileName
	if [ $fileName == "all" ]
	then
		#adding files to the staging are
		git add .
	else
		git add $fileName
	fi
	#commiting current snapshot to the local repo
	git commit -m "commit changes to local repo"

#if user wants to execute commit and push to dev
elif [ $task == "push" ]
then
	#Asking for the file name as user input 
	echo "Enter the file name to be Updated :"
	read fileName
	if [ $fileName == "all" ]
	then
		#adding files to the staging are
		git add .
	else
		git add $fileName
	fi
	git commit -m "commit for push request on dev"
	git push origin dev
#if user wants to run the project and then push to master 
elif [ $task == "run" ]
then
	#Asking for the file name as user input 
	echo "Enter the file name to be Updated :"
	read fileName
	#Asking for the ENV as user input 
	echo "Enter the Enviroment for the project build :"
	read env
	mvn clean install -P $env
	if [ $fileName == "all" ]
	then
		#adding files to the staging are
		git add .
	else
		git add $fileName
	fi
	git commit -m "commiting after execution of project"
	git push origin dev
else
	echo "incorrect input"
fi

