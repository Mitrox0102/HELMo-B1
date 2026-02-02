.data
TAB:		.word	1, 2, 3, 4, 5
LEN:		.word	5
RES:		.word 	0:5	# zone de 5x 4 octets + initialisés à 0

.text
	la $t0, TAB
	lw $t1, LEN
	li $a0, 0
	la $t3, RES	# adresse de début du tableau de résultat
	
LOOP:	beqz $t1, EXIT		# si $t1 <= 0 -> exit
	lw $t2, 0($t0)		# $t2 = valeur de l'élément courant
	add $a0, $a0, $t2	# 
	sw $a0, 0($t3)		# on stocke la somme partielle ($a0) dans RES
	subi $t1, $t1, 1	# $t1 = $t1 - 1 -> compteur -1
	addi $t0, $t0, 4	# $t0 = $t0 + 4 -> donnée suivante dans TAB
	addi $t3, $t3, 4	# $t3 = $t3 + 4 -> donnée suivante dans RES
	j LOOP			# itération suivante
	

EXIT:	la $a0, RES
	lw $a1, LEN
	jal PR_TAB_INT
	li $v0, 10		# appel systeme exit => 10
	syscall

# PR_TAB_INT($a0, $a1) -> none
# $a0 : adresse de début du tableau de INT32
# $a1 : nombre d'éléments
PR_TAB_INT:
	move $t0, $a0		#$t0 = adresse courante dans le tableau
LTAB:	blez $a1, ENDTAB	# compteur <= 0 -> fini
	lw $a0, 0($t0)		# $a0 = valeur de l'élément courant de RES
	li $v0, 1		# appel système print integer => 1
	syscall
	li $a0, '\n'
	li $v0, 11		# appel système print character => 111
	syscall
	subi $a1, $a1, 1	# on décremente le compteur
	addi $t0, $t0, 4	# on avance à l'élément suivant de RES
	j LTAB			# itération suivante

ENDTAB:	jr $ra			# return

# PR_INT($a0) -> none
PR_INT:
	li $v0, 1		# appel systeme print integer => 1
	syscall
	li $a0, '\n'
	li $v0, 11		# appel systeme print character => 11
	syscall
	jr $ra