.data
TAB:		.half	1, 2, 3, 4, 5
LEN:		.word	5

.text
	la $t0, TAB
	lw $t1, LEN
	li $t2, 0
	
LOOP:	beqz $t1, EXIT		# si $t1 <= 0 -> exit
	lh $t2, 0($t0)		# $t2 = valeur de l'élément courant
	add $a0, $a0, $t2	# $a0 = $a0 + $t2
	subi $t1, $t1, 1	# $t1 = $t1 - 1
	addi $t0, $t0, 2	# $t0 = $t0 + 2
	j LOOP			# itération suivante
	

EXIT:	jal PR_INT
	li $v0, 10		# appel systeme exit => 10
	syscall


PR_INT:
	li $v0, 1		# appel systeme print integer => 1
	syscall
	li $a0, '\n'
	li $v0, 11		# appel systeme print character => 11
	syscall
	jr $ra