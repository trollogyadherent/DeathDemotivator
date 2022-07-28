package trollogyadherent.deathdemotivator;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class ServerEventHandler {
    @SubscribeEvent()
    public void onPlayerDeath(LivingDeathEvent event) {
        EntityLivingBase entityLiving = event.entityLiving;

        if (event.isCanceled() || entityLiving == null) {
            return;
        }

        if (entityLiving instanceof EntityPlayer) {
            EntityPlayerMP entityPlayer = (EntityPlayerMP) entityLiving;
            for (Object epmp : MinecraftServer.getServer().getConfigurationManager().playerEntityList) {
                if (epmp instanceof EntityPlayerMP) {
                    ((EntityPlayerMP) epmp).addChatComponentMessage(new ChatComponentText(Config.message.replaceAll("%name%", entityPlayer.getDisplayName()).replaceAll("%ip%", entityPlayer.getPlayerIP())));
                }
            }
        }
    }
}