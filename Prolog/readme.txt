Yes, you can use any text editor, incl. VIM. Once you have written a Prolog source file, say, file.pl, you can load it into SWI-Prolog like so:

swipl -s file.pl

This will compile your file and take you to an interactive shell where you can then ask queries against the definitions in your file.

If you want to use your Prolog program in batch mode, you can use:

swipl -s file.pl -t goal

where goal is the goal/query you want to evaluate. Note that in this case you won't be getting the option to ask for alternative solutions.

