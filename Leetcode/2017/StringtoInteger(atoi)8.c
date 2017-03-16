int myAtoi(char* str)
{
	long result = 0;
	int sign = 1;
	//discard the first sequence of whitespace characters.
	while(isspace(*str)) {
		str++;
	}
	if((*str == '+') || (*str == '-')) {
		sign = (*str == '+') ? 1:0;
		str++;
	}
	if(!isdigit(*str)) {
		return 0;
	}
	while(isdigit(*str) && (result <= INT_MAX)) {
		result = result * 10 + *str - '0' + 0;
		str++;
	}
	if(result > INT_MAX) {
		return sign == 1 ? INT_MAX : INT_MIN;
	}
	return sign == 1 ? result : -result;
}