# Git-HOL 2 Solutions

1. Create a .log file and a log folder in the working directory of Git. Update the .gitignore file in such a way that on committing, these files (.log extensions and log folders) are ignored.
`touch app.log`
`mkdir log`
`echo "*.log" >> .gitignore`
`echo "log/" >> .gitignore`

2. Verify if the git status reflects the same about working directory, local repository and git repository.
`git status`
`git add .gitignore`
`git commit -m "Added .gitignore to ignore log files and folder"`
`git status`
