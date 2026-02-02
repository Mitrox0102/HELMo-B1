.data
MOT:		.ascii "HELMO"


.text
		la $s0, MOT
		lbu $a0, 0($s0)
		jal PR_INT
		
		lbu $a0, 1($s0)
		jal PR_INT
		
		lbu $a0, 2($s0)
		jal PR_INT



EXIT:	li $v0, 10		# appel systeme exit =>
	syscall


PR_INT:
	li $v0, 1		# appel systeme print integer => 1
	syscall
	li $a0, '\n'
	li $v0, 11		# appel systeme print character => 11
	syscall
	jr $ra

