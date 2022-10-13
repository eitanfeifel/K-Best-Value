import java.util.*;
public class KBestCounter<T extends Comparable<? super T>> implements KBest<T>
{

    PriorityQueue<T> elements = new PriorityQueue<>();
    int k;
    
    public KBestCounter( int k )
    {
       this.k = k;
    }

    //processes each element and adds it to the queue
    //if the queue reaches the length of k, each subsequent element
    //is added only if it is  larger than the smallest element in the queue
    public void count(T x)
    {
        if ( elements.size() < k )
        {
            elements.add( x );
        }else if( x.compareTo( elements.peek() ) > 0  && elements.size() == k  )
        {
            elements.remove();
            elements.add( x ); 
        }
    }

    //creates a list and each element of the queue is added to the list by popping off the queue
    //each element added to the list is then added back to the queue in order to preserve the elements
    //of the queue for future uses. The list of elements is returned
    public List<T> kbest()
    {
        List<T> kthList = new ArrayList<>();
        
        while( !elements.isEmpty()  )
        { 
            kthList.add( elements.poll() );
        }
        for ( int j = 0 ; j < kthList.size() ; j++ )
        {
            elements.offer( kthList.get( j ) );

        }

        return kthList;

    }


}
