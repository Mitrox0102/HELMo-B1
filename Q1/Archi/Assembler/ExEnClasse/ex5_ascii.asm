.data
TEXTE:			.ascii "HELMO"
LONGUEUR:		.word 5


.text
	la $t0, TEXTE		# $t0 = adresse de début de chaine
	lw $t1, LONGUEUR	# $t1 = le nombre de caractères
	
LOOP:	blez $t1, EXIT		# si $t1 <= 0 -> exit
	lbu $a0, 0($t0)		# $a0 = code ascii du caractère courant
	jal PR_INT		# Affichage
	subi $t1, $t1, 1	# $t1 = $t1 - 1
	addi $t0, $t0, 1	# $t0 = $t0 + 1
	j LOOP			# itération suivante


EXIT:	li $v0, 10		# appel systeme exit =>
	syscall


PR_INT:
	li $v0, 1		# appel systeme print integer => 1
	syscall
	li $a0, '\n'
	li $v0, 11		# appel systeme print character => 11
	syscall
	jr $ra