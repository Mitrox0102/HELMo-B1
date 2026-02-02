.data
TEXTE:			.asciiz "HELMO"


.text
	la $t0, TEXTE		# $t0 = adresse de début de chaine
	
LOOP:	lbu $a0, 0($t0)		# $a0 = code ascii du caractère courant
	beqz $a0, EXIT		# si $a0 = 0 -> exit
	
	jal PR_INT		# Affichage
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