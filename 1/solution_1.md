# Git-HOL 1 Solutions

1. To check if Git client is installed properly:
`git --version`

2. To configure user level configuration of user ID and email ID execute:
`git config --global user.name "Your Name"`
`git config --global user.email "your.email@example.com"`

3. To check if the configuration is properly set, execute the following command:
`git config --list`

4. Step 2: Integrate notepad++.exe to Git and make it a default editor
To check, if notepad++.exe execute from Git bash:
`notepad++`

5. To add path of notepad++.exe to environment variable, go to control panel -> System -> Advanced System settings. Go to Advanced tab -> Environment variables -> Add path of notepad++.exe to the path user variable by clicking on Edit. Exit Git bash shell, open bash shell and execute:
`notepad++`

6. To create an alias command for notepad++.exe, execute:
`alias npp="notepad++"`

7. To configure the editor, execute the command:
`git config --global core.editor notepad++`

8. To verify if notepad++ is the default editor, execute the command:
`git config --global -e`

9. Step 3: Add a file to source code repository
Open Git bash shell and create a new project GitDemo by executing the command:
`mkdir GitDemo`
`cd GitDemo`
`git init`

10. Git bash initializes the GitDemo repository. To verify, execute the command:
`ls -la`

11. To create a file welcome.txt and add content to the file, execute the command:
`echo "welcome" > welcome.txt`

12. To verify if the file welcome.txt is created, execute:
`ls`

13. To verify the content, execute the command:
`cat welcome.txt`

14. Check the status by executing:
`git status`

15. To make the file to be tracked by Git repository, execute the command:
`git add welcome.txt`

16. To add multi line comments, we are opening default editor to comment. Execute the command:
`git commit`

17. To check if local and Working Directory git repository are same, execute git status:
`git status`

18. To pull the remote repository, execute:
`git pull origin master`

19. To push the local to remote repository, execute:
`git push origin master`
