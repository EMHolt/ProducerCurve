public class ConsumerCurveBraden extends AbstractCurve {
    public void sort() {

        for (int i = 0; i < myCurve.size() - 1; i++)
        {
            int min = i;

            for (int j = i + 1; j < myCurve.size(); j++) {
                if (myCurve.get(j).getQuantity() < myCurve.get(min).getQuantity()) {
                    min = j;
                }
            }

            Point temp = myCurve.get(min);
            myCurve.set(min, myCurve.get(i));
            myCurve.set(i, temp);
        }
    }
}