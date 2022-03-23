
#!/bin/bash
if [ $1 == "commit" ]
then

#add changes to the staging area
git add .

#commit the current snapshot to the local branch 
git commit -m "script test commit"

fi

