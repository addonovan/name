/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Austin Donovan (addonovan)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package addonovan.kftc.config

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * The activity responsible for showing the profiles and allowing
 * the user to configure them.
 *
 * @author addonovan
 * @since 8/27/16
 */
class ConfigActivity : AppCompatActivity()
{

    //
    // Vars
    //

    /** The current fragment we're seeing. */
    lateinit var CurrentFragment: CustomFragment;

    //
    // Overrides
    //

    override fun onCreate( savedInstanceState: Bundle? )
    {
        super.onCreate( savedInstanceState );

        // add the main fragment and let it handle that stuff
        CurrentFragment = FragmentConfigurations();
        fragmentManager.beginTransaction().replace( android.R.id.content, CurrentFragment ).commit();
    }

    override fun onBackPressed()
    {
        // if the CurrentFragment didn't handle it, then we go back
        if ( !CurrentFragment.onBackPressed() )
        {
            super.onBackPressed();
        }
    }

    override fun onDestroy()
    {
        // save our edits
        Configurations.save();
        super.onDestroy();
    }

}