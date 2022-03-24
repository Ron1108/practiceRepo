
#!/bin/bash
if [ $1 == "commit" ]
then
	#adding files to the staging are
	git add .
	#commiting current snapshot to the local repo
	git commit -m "commit changes to local repo"

elif [ $1 == "push" ] && [ $2 = "master" ]
then
        git add .
        git commit -m "commit for push request on master"
        git checkout master
	git push origin master

#if user wants to execute commit and push to master
elif [ $1 == "push" ]
then
	git add .
	git commit -m "commit for push request on dev"
	git push origin dev
#if user wants to run the project and then push to master 
elif [ $1 == "run" ]
then
	mvn clean install -P $2
	git add .
	git commit -m "commiting after execution of project"
	git push origin dev
else
	echo "incorrect input"
fi

