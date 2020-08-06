#include <stdio.h>
#include <math.h>
#define PI 3.14259265
#define rtd(radian) radian * 180 / PI
#define dtr(degree) degree * PI / 180

int main(void)
{
	int mode;
	double r, t, x, y;
	printf("Polar Soordinate System(0)  Cartesian Coordinate System(1)\n");
	printf("Select mode: ");
	scanf("%d", &mode);

	switch (mode)
	{
	case 0: 
		printf("Enter the radius and degree: ");
		scanf("%lf%lf", &r, &t);
		printf("x: %lf\ny: %lf\n", r * cos(dtr(t)), r * sin(dtr(t)));
		break;

	case 1:
		printf("Enter the x and y: ");
		scanf("%lf%lf", &x, &y);
		r = sqrt(x * x + y * y);
		printf("r: %lf\ntheta: %lf\n", r, rtd(asin(x / r)));
		break;
	}
	return 0;
}