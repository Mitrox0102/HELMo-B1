.data
MOT:        .asciiz "HELMO EST UNE ECOLE"
ALPHABET:    .asciiz "ABCDEFGHIJKLMNKRSTUVWXYZ"
FLECHE:        .asciiz " -> "
.text
    la $t1 ALPHABET
LOOP_M:    lbu $a1, 0($t1)
    beqz $a1, EXIT
    la $a0 MOT
    jal NB_OCC
    move $t4, $v0
    beqz $t4, SUITE2
    move $a0, $a1
    li $v0, 11
    syscall
    la $a0, FLECHE
    li $v0, 4
    syscall 
    move $a0, $t4
    li $v0 1
    syscall
    jal PB_INT
SUITE2:    addi $t1, $t1, 1
    j LOOP_M

EXIT:    li $v0 10
    syscall

PB_INT:
    li $a0, '\n'
    li $v0, 11
    syscall
    jr $ra
    
NB_OCC: li $v0, 0
LOOP:   lbu $t0, 0($a0)
        beqz $t0, END
        addi $a0, $a0, 1
        bne $t0, $a1, LOOP
        addi $v0, $v0, 1
        j LOOP
END:    jr $ra