.data
TAB:		.word	1, 2, 3, 4, 5

.text
	la $t0, TAB
	lw $a0, 0($t0)
	jal PR_INT

	lw $a0, 4($t0)
	jal PR_INT

	lw $a0, 8($t0)
	jal PR_INT

	j EXIT


EXIT:	li $v0, 10		# appel systeme exit =>
	syscall


PR_INT:
	li $v0, 1		# appel systeme print integer => 1
	syscall
	li $a0, '\n'
	li $v0, 11		# appel systeme print character => 11
	syscall
	jr $ra