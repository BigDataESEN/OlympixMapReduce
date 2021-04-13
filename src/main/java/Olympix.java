import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class Olympix {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // Créer la configuration
        Configuration conf = new Configuration();
        // Préciser les clé/valeur de la fonction map
        if(args.length >= 4){
            conf.setInt("MAP_KEY", Integer.parseInt(args[2]));
            conf.setInt("MAP_VALUE", Integer.parseInt(args[3]));
        }
        // Créer le job
        Job olympixJob = Job.getInstance(conf, "Olympix job");
        // Définir la classe principale
        olympixJob.setJarByClass(Olympix.class);
        // Définir la classe mapper
        olympixJob.setMapperClass(OlympixMapper.class);
        // Définir la classe reducer
        olympixJob.setReducerClass(OlympixReducer.class);
        // Définir le type du clé output
        olympixJob.setOutputKeyClass(Text.class);
        // Définir le type de la valeur output
        olympixJob.setOutputValueClass(IntWritable.class);
        // Ajouter le fichier à traiter
        FileInputFormat.addInputPath(olympixJob, new Path(args[0]));
        // Output
        FileOutputFormat.setOutputPath(olympixJob, new Path(args[1]));
        // Exécuter le job
        System.exit(olympixJob.waitForCompletion(true) ? 0 : 1);
    }

}
