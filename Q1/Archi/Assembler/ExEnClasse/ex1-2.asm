.data
A:	.word	123456
B:	.word	987654

.text
lw $s0, A
lw $s1, B

add $s2, $s0, $s1      # $s2 = $s0 + $s1

move $a0, $s2		#$a0 = $s2
li $v0, 1		# Appel systeme pour print
syscall