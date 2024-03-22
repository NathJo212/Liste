public class Liste {
    private int nbElements;
    private Noeud premier;

    public Liste() {
        premier = null;
        nbElements = 0;
    }

    public String toString() {
        String str = "[";
        for (Noeud courant = premier; courant != null; courant = courant.suivant) {
            if (courant.suivant == null) {
                str += courant.valeur;
            } else {
                str += courant.valeur + ", ";
            }
        }
        return str + "]";
    }


    public int getElementAt(int index) {
        int indexCourant = 0;
        for (Noeud courant = premier; courant != null; courant = courant.suivant){
            if (indexCourant == index)
                return courant.valeur;
            else
                indexCourant++;
        }
        return -1;
    }

    public int getNbElements() {
        return nbElements;
    }

    public boolean estVide() {
        return nbElements == 0;
    }

    public void ajouter(int element) {
        if (premier == null) {
            premier = new Noeud();
            premier.valeur = element;
            premier.suivant = null;
        } else {
            Noeud dernier = premier;
            while (dernier.suivant != null)
                dernier = dernier.suivant;
            dernier.suivant = new Noeud();
            dernier = dernier.suivant;
            dernier.valeur = element;
            dernier.suivant = null;
        }
        nbElements++;
    }

    public void ajouterD(int element) {
        Noeud nouveau = new Noeud();
        nouveau.valeur = element;
        if (premier == null) {
            premier = new Noeud();
            premier.valeur = element;
            premier.suivant = null;
        } else {
            nouveau.suivant = premier;
        }
        premier = nouveau;
        nbElements++;
    }

    public void ajouter(int element, int index) {
        if (index == 0) {
            ajouterD(element);
            return;
        }
        if (index < 0)
            return;
        Noeud nouveau = new Noeud();
        nouveau.valeur = element;
        Noeud courant = premier;
        int i = 0;
        while (i < index - 1 && courant != null) {
            courant = courant.suivant;
            i++;
        }
        if (courant == null)
            return;
        nouveau.suivant = courant.suivant;
        courant.suivant = nouveau;
        nbElements++;
    }

    public void efface(){
        if (premier != null){
            premier = premier.suivant;
            nbElements--;
        }
    }
    public void effaceD(){
        Noeud courant = premier;
        if (premier != null){
            int index = 0;
            int avantDernier = nbElements-2;
            while (index != avantDernier){
                courant = courant.suivant;
                index++;
            }
            courant.suivant = null;
            nbElements--;
        }
    }
/*
    public void ajouter(Liste autre) {
        for (int i = 0 ; i < autre.getNbElements(); i++)
            this.ajouter(autre.getElementAt(i));
    }

    private void resize() {
        int[] nouveau = new int[RATIO_AGRANDISSEMENT * tableau.length];
        for (int i = 0 ; i < tableau.length; i++)
            nouveau[i] = tableau[i];
        tableau = nouveau;
    }

    public int trouver(int valeur) {
        for (int i = 0; i < nbElements; i++)
            if (tableau[i] == valeur)
                return i;
        return -1;
    }

    public boolean trouverTout(Liste autre) {
        for (int i = 0 ; i < autre.getNbElements(); i++)
            if (this.trouver(autre.getElementAt(i)) == -1)
                return false;
        return true;
    }

    public boolean effacerAt(int index) {
        if (index < 0 || index > nbElements)
            //throw new IndexOutOfBoundsException();
            return false;
        for (int i = index; i < nbElements; i++)
            tableau[i] = tableau[i + 1];
        nbElements--;
        return true;
    }

    public boolean effacerTout(Liste autre) {
        boolean result = false;
        for (int i = 0; i < autre.getNbElements(); i++) {
            int valeurAEffacer = autre.getElementAt(i);
            int indexAEffacer = trouver(valeurAEffacer);
            if (indexAEffacer != -1) {
                this.effacerAt(indexAEffacer);
                result = true;
            }
        }
        return result;
    }

    public void effacerTout() {
        tableau = new int[TAILLE_INITIALE];
        nbElements = 0;
    */
}
