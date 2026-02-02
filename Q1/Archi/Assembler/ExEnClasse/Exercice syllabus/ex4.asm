.data

TEXT:		.asciiz "LA PROGRAMMATION EN ASSEMBLEUR EST UN ART"
CHARs:		.asciiz	'AEIOUY'

.text
	
	la $t0, TEXT		# adresse de début
	lbu $t1, CHAR		# caractère recherché
	li $t3, 0
	
LOOP:	lbu $t2, 0($t0)		# on charge le caractère
	beqz $t2, EXIT		# si c'est le caractère '\0', on a fini
	
	move $a0, $t2		# $a0 contientle caractere a valider
	la $a1, CHARS		# $a1 contient l'adresse de debut des caract?. autorisés
	jal VALID		
	add $t3, $v3		# on ajoute 0 ou 1
	
NEXT : 	addi $t0, $t0, 1	# on passe au caractère suivant
	j LOOP			# itération suivante
	

PR_INT:
	li $v0, 1		# appel systeme print integer => 1
	syscall
	jr $ra
	
	
# VALIDE($a0, $a1) -> $v0 (0 = valide, 1 = invalide)
# $a0 : le caractère à valider
# $a1 : l'adresse de début de la chaine des caractères valides

VALID:
	li $v0, 0		# par défaut on suppose invalide

L_VALID:lbu $t4, 0($a1)		# on charge un caractère autorisé
	beqz $t4, E_VALID	# fin de chaine -> on a fini (0 invalide)
	beq $a0, $t4, TROUVE	# on a trouve un caractere valide
	addi $a1, $a1, 1	# on passe au caractère suivant
	j L_VALID		# itération suivante
	
TROUVE: li $v0,1
	
E_VALID:
	jr $ra			# return

EXIT:	move $a0, $t3
	jal PR_INT
	li $v0, 10		# appel systeme exit => 10
	syscall
