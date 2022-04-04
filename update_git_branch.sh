#!/bin/bash
echo "Enter the file name to be commited :"
read task
if [ $task == "commit" ]
then
	#Asking for the file name as user input 
	echo "Enter the file name to be commited :"
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
	mvn clean install -P $2
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

