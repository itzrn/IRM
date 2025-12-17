"""
To install any lib
    pip install libname


you can keep one version of any lib at a time, if you change the
previous version will lost and you will get the installed one
-> so instead doinf this we can create virtual env, which have no connection
    to global intertpreter packages, bcz we making an isolated environment
Virtual environments are same as the system interpreter but is isolated
from the other python environment on the system


To install a virtual env
    pip install virtualenv

making an env
    virtualenv new_env

To activate the particular env
open cmd and direct to the folder where you have created the environment

.\new_env\Scripts\activate.ps1
    after hitting enter the env will get actiavted

To deactivate the virtual environment
write deactivate and hit enter

now anything you install will get install in that particular environment



To know what are all the packages is installed in your anvironment
use
    pip freeze
To save all the packages name and there version
    pip freeze > requirements.txt
To recreate the virtual environments using requirenments.txt
    pip install -r .\requirements.txt

"""


