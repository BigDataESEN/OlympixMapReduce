import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class OlympixReducer extends Reducer<Text, Iterable<IntWritable>, Text, IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<Iterable<IntWritable>> values, Context context) throws IOException, InterruptedException {
        Iterator liste = values.iterator();
        int total = 0;
        while(liste.hasNext()){
            IntWritable nombreMedailles = (IntWritable) liste.next();
            total += nombreMedailles.get();
        }
        context.write(key, new IntWritable(total));
    }
}
