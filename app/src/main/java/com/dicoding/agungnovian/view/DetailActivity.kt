package com.dicoding.agungnovian.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.dicoding.agungnovian.R
import com.dicoding.agungnovian.helper.Energy
import com.dicoding.agungnovian.model.data.CardData


class DetailActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(findViewById(R.id.toolbar))

        val args : Bundle? = intent.extras
        val card : CardData = args?.get("card") as CardData
        title = card.name

        val imgFull = findViewById<ImageView>(R.id.imgFull)
        //val imgEnergyTitle = findViewById<ImageView>(R.id.imgEnergyTitle)
        val tvwType = findViewById<TextView>(R.id.tvwType)
        val tvwSubType = findViewById<TextView>(R.id.tvwSubType)
        val tvwAbilityType = findViewById<TextView>(R.id.tvwAbilityType)
        val tvwAbilityName = findViewById<TextView>(R.id.tvwAbilityName)
        val tvwAbilityText = findViewById<TextView>(R.id.tvwAbilityText)
        val tvwRules = findViewById<TextView>(R.id.tvwRules)
        val tvwText1 = findViewById<TextView>(R.id.tvwText1)
        val tvwText2 = findViewById<TextView>(R.id.tvwText2)
        val tvwText3 = findViewById<TextView>(R.id.tvwText3)

        val rowAttack1 = findViewById<TableRow>(R.id.rowAttack1)
        val tvwAttackText1 = findViewById<TextView>(R.id.tvwAttackText1)
        val imgAttackCost11 = findViewById<ImageView>(R.id.imgAttackCost11)
        val imgAttackCost12 = findViewById<ImageView>(R.id.imgAttackCost12)
        val imgAttackCost13 = findViewById<ImageView>(R.id.imgAttackCost13)
        val tvwAttackName1 = findViewById<TextView>(R.id.tvwAttackName1)
        val tvwAttackDamage1 = findViewById<TextView>(R.id.tvwAttackDamage1)

        val rowAttack2 = findViewById<TableRow>(R.id.rowAttack2)
        val tvwAttackText2 = findViewById<TextView>(R.id.tvwAttackText2)
        val imgAttackCost21 = findViewById<ImageView>(R.id.imgAttackCost21)
        val imgAttackCost22 = findViewById<ImageView>(R.id.imgAttackCost22)
        val imgAttackCost23 = findViewById<ImageView>(R.id.imgAttackCost23)
        val tvwAttackName2 = findViewById<TextView>(R.id.tvwAttackName2)
        val tvwAttackDamage2 = findViewById<TextView>(R.id.tvwAttackDamage2)

        val rowAttack3 = findViewById<TableRow>(R.id.rowAttack3)
        val tvwAttackText3 = findViewById<TextView>(R.id.tvwAttackText3)
        val imgAttackCost31 = findViewById<ImageView>(R.id.imgAttackCost31)
        val imgAttackCost32 = findViewById<ImageView>(R.id.imgAttackCost32)
        val imgAttackCost33 = findViewById<ImageView>(R.id.imgAttackCost33)
        val tvwAttackName3 = findViewById<TextView>(R.id.tvwAttackName3)
        val tvwAttackDamage3 = findViewById<TextView>(R.id.tvwAttackDamage3)

        val rowWeakness1 = findViewById<TableRow>(R.id.rowWeakness1)
        val rowWeakness2 = findViewById<TableRow>(R.id.rowWeakness2)
        val tvwWeakness1 = findViewById<TextView>(R.id.tvwWeakness1)
        val tvwWeakness2 = findViewById<TextView>(R.id.tvwWeakness2)
        val imgWeakness1 = findViewById<ImageView>(R.id.imgWeakness1)
        val imgWeakness2 = findViewById<ImageView>(R.id.imgWeakness2)

        val rowResistance1 = findViewById<TableRow>(R.id.rowResistance1)
        val rowResistance2 = findViewById<TableRow>(R.id.rowResistance2)
        val tvwResistance1 = findViewById<TextView>(R.id.tvwResistance1)
        val tvwResistance2 = findViewById<TextView>(R.id.tvwResistance2)
        val imgResistance1 = findViewById<ImageView>(R.id.imgResistance1)
        val imgResistance2 = findViewById<ImageView>(R.id.imgResistance2)

        val imgRetreat1 = findViewById<ImageView>(R.id.imgRetreat1)
        val imgRetreat2 = findViewById<ImageView>(R.id.imgRetreat2)

        val tvwArtist = findViewById<TextView>(R.id.tvwArtist)
        val tvwRarity = findViewById<TextView>(R.id.tvwRarity)
        val tvwSet = findViewById<TextView>(R.id.tvwSet)

        val linWeakness = findViewById<LinearLayout>(R.id.linWeakness)
        val linRetreat = findViewById<LinearLayout>(R.id.linRetreat)
        val linResistance = findViewById<LinearLayout>(R.id.linResistance)

        linWeakness.visibility = View.GONE
        linRetreat.visibility = View.GONE
        linResistance.visibility = View.GONE

        tvwType.text = card.name
        tvwSubType.text = card.supertype + " - " + card.subtype

        tvwArtist.text = card.artist
        tvwRarity.text = card.rarity
        tvwSet.text = card.set

        if (card.ability == null){
            tvwAbilityType.visibility = View.GONE
            tvwAbilityName.visibility = View.GONE
            tvwAbilityText.visibility = View.GONE
        }

        tvwRules.visibility = View.GONE
        tvwText1.visibility = View.GONE
        tvwText2.visibility = View.GONE
        tvwText3.visibility = View.GONE

        if (card.text != null){
            tvwRules.visibility = View.VISIBLE
            when (card.text!!.size) {
                1 -> {
                    tvwText1.visibility = View.VISIBLE
                    tvwText1.text = card.text!![0]
                }
                2 -> {
                    tvwText1.visibility = View.VISIBLE
                    tvwText2.visibility = View.VISIBLE
                    tvwText1.text = card.text!![0]
                    tvwText2.text = card.text!![1]
                }
                3 -> {
                    tvwText1.visibility = View.VISIBLE
                    tvwText2.visibility = View.VISIBLE
                    tvwText3.visibility = View.VISIBLE
                    tvwText1.text = card.text!![0]
                    tvwText2.text = card.text!![1]
                    tvwText3.text = card.text!![2]
                }
            }
        }

        tvwAbilityType.text = card.ability?.type ?: ""
        tvwAbilityName.text = card.ability?.name ?: ""
        tvwAbilityText.text = card.ability?.text ?: ""

        //Energy.draw(this, imgEnergyTitle, "fire")

        rowAttack1.visibility = View.GONE
        tvwAttackText1.visibility = View.GONE
        tvwAttackName1.visibility = View.GONE
        tvwAttackDamage1.visibility = View.GONE

        rowAttack2.visibility = View.GONE
        tvwAttackText2.visibility = View.GONE
        tvwAttackName2.visibility = View.GONE
        tvwAttackDamage2.visibility = View.GONE

        rowAttack3.visibility = View.GONE
        tvwAttackText3.visibility = View.GONE
        tvwAttackName3.visibility = View.GONE
        tvwAttackDamage3.visibility = View.GONE

        imgAttackCost11.visibility = View.GONE
        imgAttackCost12.visibility = View.GONE
        imgAttackCost13.visibility = View.GONE

        imgAttackCost21.visibility = View.GONE
        imgAttackCost22.visibility = View.GONE
        imgAttackCost23.visibility = View.GONE

        imgAttackCost31.visibility = View.GONE
        imgAttackCost32.visibility = View.GONE
        imgAttackCost33.visibility = View.GONE

        if (card.attacks != null){
            when (card.attacks!!.size) {
                1 -> {
                    rowAttack1.visibility = View.VISIBLE
                    tvwAttackText1.visibility = View.VISIBLE
                    tvwAttackName1.visibility = View.VISIBLE
                    tvwAttackDamage1.visibility = View.VISIBLE

                    tvwAttackName1.text = card.attacks!![0].name
                    tvwAttackText1.text = card.attacks!![0].text
                    tvwAttackDamage1.text = " | " +  card.attacks!![0].damage

                    if (card.attacks!![0].cost != null){
                        when (card.attacks!![0].cost?.size) {
                            1 -> {
                                card.attacks!![0].cost?.get(0)?.let {
                                    Energy.draw(this, imgAttackCost11, it)
                                    imgAttackCost11.visibility = View.VISIBLE
                                }
                            }
                            2 -> {
                                card.attacks!![0].cost?.get(0)?.let {
                                    Energy.draw(this, imgAttackCost11, it)
                                    imgAttackCost11.visibility = View.VISIBLE
                                }
                                card.attacks!![0].cost?.get(1)?.let {
                                    Energy.draw(this, imgAttackCost12, it)
                                    imgAttackCost12.visibility = View.VISIBLE
                                }
                            }
                            3 -> {
                                card.attacks!![0].cost?.get(0)?.let {
                                    Energy.draw(this, imgAttackCost11, it)
                                    imgAttackCost11.visibility = View.VISIBLE
                                }
                                card.attacks!![0].cost?.get(1)?.let {
                                    Energy.draw(this, imgAttackCost12, it)
                                    imgAttackCost12.visibility = View.VISIBLE
                                }
                                card.attacks!![0].cost?.get(2)?.let {
                                    Energy.draw(this, imgAttackCost13, it)
                                    imgAttackCost13.visibility = View.VISIBLE
                                }
                            }
                        }
                    }
                }
                2 -> {
                    rowAttack1.visibility = View.VISIBLE
                    tvwAttackText1.visibility = View.VISIBLE
                    tvwAttackName1.visibility = View.VISIBLE
                    tvwAttackDamage1.visibility = View.VISIBLE

                    rowAttack2.visibility = View.VISIBLE
                    tvwAttackText2.visibility = View.VISIBLE
                    tvwAttackName2.visibility = View.VISIBLE
                    tvwAttackDamage2.visibility = View.VISIBLE

                    tvwAttackName1.text = card.attacks!![0].name
                    tvwAttackText1.text = card.attacks!![0].text
                    tvwAttackDamage1.text = " | " +  card.attacks!![0].damage

                    tvwAttackName2.text = card.attacks!![1].name
                    tvwAttackText2.text = card.attacks!![1].text
                    tvwAttackDamage2.text = " | " +  card.attacks!![1].damage

                    if (card.attacks!![0].cost != null){
                        when (card.attacks!![0].cost?.size) {
                            1 -> {
                                card.attacks!![0].cost?.get(0)?.let {
                                    Energy.draw(this, imgAttackCost11, it)
                                    imgAttackCost11.visibility = View.VISIBLE
                                }
                            }
                            2 -> {
                                card.attacks!![0].cost?.get(0)?.let {
                                    Energy.draw(this, imgAttackCost11, it)
                                    imgAttackCost11.visibility = View.VISIBLE
                                }
                                card.attacks!![0].cost?.get(1)?.let {
                                    Energy.draw(this, imgAttackCost12, it)
                                    imgAttackCost12.visibility = View.VISIBLE
                                }
                            }
                            3 -> {
                                card.attacks!![0].cost?.get(0)?.let {
                                    Energy.draw(this, imgAttackCost11, it)
                                    imgAttackCost11.visibility = View.VISIBLE
                                }
                                card.attacks!![0].cost?.get(1)?.let {
                                    Energy.draw(this, imgAttackCost12, it)
                                    imgAttackCost12.visibility = View.VISIBLE
                                }
                                card.attacks!![0].cost?.get(2)?.let {
                                    Energy.draw(this, imgAttackCost13, it)
                                    imgAttackCost13.visibility = View.VISIBLE
                                }
                            }
                        }
                    }

                    if (card.attacks!![1].cost != null){
                        when (card.attacks!![1].cost?.size) {
                            1 -> {
                                card.attacks!![1].cost?.get(0)?.let {
                                    Energy.draw(this, imgAttackCost21, it)
                                    imgAttackCost21.visibility = View.VISIBLE
                                }
                            }
                            2 -> {
                                card.attacks!![1].cost?.get(0)?.let {
                                    Energy.draw(this, imgAttackCost21, it)
                                    imgAttackCost21.visibility = View.VISIBLE
                                }
                                card.attacks!![1].cost?.get(1)?.let {
                                    Energy.draw(this, imgAttackCost22, it)
                                    imgAttackCost22.visibility = View.VISIBLE
                                }
                            }
                            3 -> {
                                card.attacks!![1].cost?.get(0)?.let {
                                    Energy.draw(this, imgAttackCost21, it)
                                    imgAttackCost21.visibility = View.VISIBLE
                                }
                                card.attacks!![1].cost?.get(1)?.let {
                                    Energy.draw(this, imgAttackCost22, it)
                                    imgAttackCost22.visibility = View.VISIBLE
                                }
                                card.attacks!![1].cost?.get(2)?.let {
                                    Energy.draw(this, imgAttackCost23, it)
                                    imgAttackCost23.visibility = View.VISIBLE
                                }
                            }
                        }
                    }
                }
                3 -> {
                    rowAttack1.visibility = View.VISIBLE
                    tvwAttackText1.visibility = View.VISIBLE
                    tvwAttackName1.visibility = View.VISIBLE
                    tvwAttackDamage1.visibility = View.VISIBLE

                    rowAttack2.visibility = View.VISIBLE
                    tvwAttackText2.visibility = View.VISIBLE
                    tvwAttackName2.visibility = View.VISIBLE
                    tvwAttackDamage2.visibility = View.VISIBLE

                    rowAttack3.visibility = View.VISIBLE
                    tvwAttackText3.visibility = View.VISIBLE
                    tvwAttackName3.visibility = View.VISIBLE
                    tvwAttackDamage3.visibility = View.VISIBLE

                    tvwAttackName1.text = card.attacks!![0].name
                    tvwAttackText1.text = card.attacks!![0].text
                    tvwAttackDamage1.text = " | " +  card.attacks!![0].damage

                    tvwAttackName2.text = card.attacks!![1].name
                    tvwAttackText2.text = card.attacks!![1].text
                    tvwAttackDamage2.text = " | " +  card.attacks!![1].damage

                    tvwAttackName3.text = card.attacks!![2].name
                    tvwAttackText3.text = card.attacks!![2].text
                    tvwAttackDamage3.text = " | " +  card.attacks!![2].damage

                    if (card.attacks!![0].cost != null){
                        when (card.attacks!![0].cost?.size) {
                            1 -> {
                                card.attacks!![0].cost?.get(0)?.let {
                                    Energy.draw(this, imgAttackCost11, it)
                                    imgAttackCost11.visibility = View.VISIBLE
                                }
                            }
                            2 -> {
                                card.attacks!![0].cost?.get(0)?.let {
                                    Energy.draw(this, imgAttackCost11, it)
                                    imgAttackCost11.visibility = View.VISIBLE
                                }
                                card.attacks!![0].cost?.get(1)?.let {
                                    Energy.draw(this, imgAttackCost12, it)
                                    imgAttackCost12.visibility = View.VISIBLE
                                }
                            }
                            3 -> {
                                card.attacks!![0].cost?.get(0)?.let {
                                    Energy.draw(this, imgAttackCost11, it)
                                    imgAttackCost11.visibility = View.VISIBLE
                                }
                                card.attacks!![0].cost?.get(1)?.let {
                                    Energy.draw(this, imgAttackCost12, it)
                                    imgAttackCost12.visibility = View.VISIBLE
                                }
                                card.attacks!![0].cost?.get(2)?.let {
                                    Energy.draw(this, imgAttackCost13, it)
                                    imgAttackCost13.visibility = View.VISIBLE
                                }
                            }
                        }
                    }

                    if (card.attacks!![1].cost != null){
                        when (card.attacks!![1].cost?.size) {
                            1 -> {
                                card.attacks!![1].cost?.get(0)?.let {
                                    Energy.draw(this, imgAttackCost21, it)
                                    imgAttackCost21.visibility = View.VISIBLE
                                }
                            }
                            2 -> {
                                card.attacks!![1].cost?.get(0)?.let {
                                    Energy.draw(this, imgAttackCost21, it)
                                    imgAttackCost21.visibility = View.VISIBLE
                                }
                                card.attacks!![1].cost?.get(1)?.let {
                                    Energy.draw(this, imgAttackCost22, it)
                                    imgAttackCost22.visibility = View.VISIBLE
                                }
                            }
                            3 -> {
                                card.attacks!![1].cost?.get(0)?.let {
                                    Energy.draw(this, imgAttackCost21, it)
                                    imgAttackCost21.visibility = View.VISIBLE
                                }
                                card.attacks!![1].cost?.get(1)?.let {
                                    Energy.draw(this, imgAttackCost22, it)
                                    imgAttackCost22.visibility = View.VISIBLE
                                }
                                card.attacks!![1].cost?.get(2)?.let {
                                    Energy.draw(this, imgAttackCost23, it)
                                    imgAttackCost23.visibility = View.VISIBLE
                                }
                            }
                        }
                    }
                }
            }
        }

        rowWeakness1.visibility = View.GONE
        rowWeakness2.visibility = View.GONE
        tvwWeakness1.visibility = View.GONE
        tvwWeakness2.visibility = View.GONE
        imgWeakness1.visibility = View.GONE
        imgWeakness2.visibility = View.GONE

        rowResistance1.visibility = View.GONE
        rowResistance2.visibility = View.GONE
        tvwResistance1.visibility = View.GONE
        tvwResistance2.visibility = View.GONE
        imgResistance1.visibility = View.GONE
        imgResistance2.visibility = View.GONE

        imgRetreat1.visibility = View.GONE
        imgRetreat2.visibility = View.GONE

        if (card.weaknesses != null){
            linWeakness.visibility = View.VISIBLE

            if (card.weaknesses!!.size == 1){
                rowWeakness1.visibility = View.VISIBLE
                card.weaknesses!![0].type.let {
                    Energy.draw(this, imgWeakness1, it)
                    imgWeakness1.visibility = View.VISIBLE
                }
                card.weaknesses!![0].value.let {
                    tvwWeakness1.text = it
                    tvwWeakness1.visibility = View.VISIBLE
                }
            } else if (card.weaknesses!!.size == 2){
                rowWeakness1.visibility = View.VISIBLE
                card.weaknesses!![0].type.let {
                    Energy.draw(this, imgWeakness1, it)
                    imgWeakness1.visibility = View.VISIBLE
                }
                card.weaknesses!![0].value.let {
                    tvwWeakness1.text = it
                    tvwWeakness1.visibility = View.VISIBLE
                }
                card.weaknesses!![1].type.let {
                    Energy.draw(this, imgWeakness2, it)
                    imgWeakness2.visibility = View.VISIBLE
                }
                card.weaknesses!![1].value.let {
                    tvwWeakness2.text = it
                    tvwWeakness2.visibility = View.VISIBLE
                }

            }
        }

        if (card.resistances != null){
            linResistance.visibility = View.VISIBLE

            if (card.resistances!!.size == 1){
                rowResistance1.visibility = View.VISIBLE
                card.resistances!![0].type.let {
                    Energy.draw(this, imgResistance1, it)
                    imgResistance1.visibility = View.VISIBLE
                }
                card.resistances!![0].value.let {
                    tvwResistance1.text = it
                    tvwResistance1.visibility = View.VISIBLE
                }
            } else if (card.weaknesses!!.size == 2){
                rowResistance1.visibility = View.VISIBLE
                card.resistances!![0].type.let {
                    Energy.draw(this, imgResistance1, it)
                    imgResistance1.visibility = View.VISIBLE
                }
                card.resistances!![0].value.let {
                    tvwResistance1.text = it
                    tvwResistance1.visibility = View.VISIBLE
                }
                rowResistance2.visibility = View.VISIBLE
                card.resistances!![1].type.let {
                    Energy.draw(this, imgResistance2, it)
                    imgResistance2.visibility = View.VISIBLE
                }
                card.resistances!![1].value.let {
                    tvwResistance2.text = it
                    tvwResistance2.visibility = View.VISIBLE
                }
            }
        }

        if (card.retreatCost != null){
            linRetreat.visibility = View.VISIBLE

            if (card.retreatCost!!.size == 1){
                rowWeakness1.visibility = View.VISIBLE
                card.retreatCost!![0].let {
                    Energy.draw(this, imgRetreat1, it)
                    imgRetreat1.visibility = View.VISIBLE
                }
            } else if (card.retreatCost!!.size == 2){
                rowWeakness1.visibility = View.VISIBLE
                card.retreatCost!![0].let {
                    Energy.draw(this, imgRetreat1, it)
                    imgRetreat1.visibility = View.VISIBLE
                }
                card.retreatCost!![1].let {
                    Energy.draw(this, imgRetreat2, it)
                    imgRetreat2.visibility = View.VISIBLE
                }
            }
        }
/*
        val circularProgressDrawable = CircularProgressDrawable(this)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        val requestOptions = RequestOptions()
        requestOptions.placeholder(circularProgressDrawable)
        requestOptions.error(R.mipmap.ic_launcher)
        requestOptions.skipMemoryCache(true)
        requestOptions.fitCenter()

        Glide.with(this)
            .load(card.imageUrlHiRes)
            .apply(requestOptions)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imgFull)
            */
        Glide.with(this)
            .load(card.imageUrlHiRes)
            .into(imgFull)
    }
}