# Complex
A programming launguage i made simular to brainf**k

I got the idea to make my own programming launguage from a awesome youtuber named Truttle1


Commands:

    ~ = none
    > = increments the pointer
    < = deincrements the pointer
    ^ = pushes the stack from the current cell
    ! = pops the stack to the current cell
    + = increment the current cell
    - = deincrement the current cell
    ? = get user input and push it to the stack
    $ = get ASCII char value from user and push it to the stack
    @ = pop the stack and outputs it to the console
    ` = pop the stack and print a char from the ascii value to the console
    \/ = jumps to the nearest "|" if the current cell does not equal 0
    \ = jumps to the nearest ":" if the current cell equals 0
    * = jump back 5 steps
    # = jump back 10 steps
    ( = pop the stack and compare it to the current cell, if equal jumps to the nearest {
    ) = pop the stack and compare it to the current cell, if not equal jumps to the nearest }
