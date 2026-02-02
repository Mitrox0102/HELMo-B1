.data

TEXT:		.asciiz "LA POROGRAMMATION EN ASSEMBLEUR EST UN ART"
CHAR:		.byte	'A'

.text
	
	la $t0, TEXT		# adresse de début
	lbu $t1, CHAR		# caractère recherché
	li $t3, 0
	
LOOP:	lbu $t2, 0($t0)		# on charge le caractère
	beqz $t2, EXIT		# si c'est le caractère '\0', on a fini
	bne $t2, $t1, NEXT 	# si le caractère courant n'est pas celui recherché on passe
	addi $t3, $t3, 1 	# on incrémente le compteur
	
NEXT : 	addi $t0, $t0, 1	# on passe au caractère suivant
	j LOOP			# itération suivante
	

PR_INT:
	li $v0, 1		# appel systeme print integer => 1
	syscall
	jr $ra


EXIT:	move $a0, $t3
	jal PR_INT
	li $v0, 10		# appel systeme exit => 10
	syscall